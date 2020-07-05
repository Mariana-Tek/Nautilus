package com.marianatek.marianakit.apiclient

import co.touchlab.stately.ensureNeverFrozen
import com.marianatek.marianakit.models.ClassSessionResults
import com.marianatek.marianakit.models.LocationsResult
import io.ktor.client.HttpClient
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.takeFrom
import kotlinx.serialization.UnstableDefault

interface MarianaApi {
    suspend fun fetchClassSessions(
        minStartDate: String? = null,
        maxStartDate: String? = null,
        locations: List<String> = emptyList(),
        pageSize: Int = 8,
        page: Int = 1
    ): ResultType<ClassSessionResults>

    suspend fun fetchLocations(): ResultType<LocationsResult>
}

class MarianaApiImpl : MarianaApi {
    @OptIn(UnstableDefault::class)
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
            connectTimeoutMillis = 15000L
            socketTimeoutMillis = 15000L
        }
    }

    init {
        ensureNeverFrozen()
    }

    override suspend fun fetchClassSessions(
        minStartDate: String?,
        maxStartDate: String?,
        locations: List<String>,
        pageSize: Int,
        page: Int
    ): ResultType<ClassSessionResults> = network {
        try {
            ResultType.Success(
                client.get<ClassSessionResults> {
                    path("classes")
                    locations.forEach { parameter("location", it) }
                    parameter("page_size", pageSize)
                    parameter("page", page)
                    minStartDate?.let { parameter("min_start_date", it) }
                    maxStartDate?.let { parameter("max_start_date", it) }
                }
            )
        } catch (t: Throwable) {
            ResultType.Failure<ClassSessionResults>(t)
        }

    }

    override suspend fun fetchLocations(): ResultType<LocationsResult> = network {
        try {
            ResultType.Success<LocationsResult>(
                client.get<LocationsResult> {
                    path("locations")
                }
            )
        } catch (throwable: Throwable) {
            ResultType.Failure<LocationsResult>(throwable)
//            when (throwable) {
//                is ClientRequestException ->
//                    when(val status = throwable.response.status.value) {
//                        403 -> {
//                            // Authorization Failure login credentials
//                            null
//                        }
//                        in 400..499 -> {
//                            // Client Side Error
//                            null
//                        }
//                        in 500..599 -> {
//                            // Server Side Error
//                            null
//                        }
//                        else -> {
//                            // Unhandled error
//                            null
//                        }
//                    }
//                else -> {
//                    // Unhandled error
//                    null
//                }
//            }
        }
    }

    private fun HttpRequestBuilder.path(path: String) {
        url {
            takeFrom("https://cousteau-r45kxk.marianatek.com")
            encodedPath = "/api/customer/v1/$path"
        }
    }
}
