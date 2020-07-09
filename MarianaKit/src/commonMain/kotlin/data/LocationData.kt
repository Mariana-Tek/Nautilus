package com.marianatek.marianakit.data

import co.touchlab.stately.ensureNeverFrozen
import com.marianatek.marianakit.apiclient.MarianaApi
import com.marianatek.marianakit.apiclient.NetworkScope
import com.marianatek.marianakit.apiclient.ResultType
import com.marianatek.marianakit.models.Location
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

interface LocationData {
    fun getLocations(): Call<List<Location>>
}

class LocationDataImpl(
        private val marianaApi: MarianaApi,
        private val networkScope: NetworkScope = NetworkScope()
): LocationData {

    init {
        ensureNeverFrozen()
    }

    override fun getLocations(): Call<List<Location>> {
        return object : Call<List<Location>> {

            private var networkCall: Job? = null

            override fun get(completion: Completion<List<Location>>) {
                networkCall = networkScope.launch {

                    when (val locationResponse = marianaApi.fetchLocations()) {
                        is ResultType.Failure -> {
                            completion.invoke(ResultType.Failure(locationResponse.throwable))
                        }
                        is ResultType.Success -> {
                            val locations = locationResponse.data.locations
                            completion.invoke(ResultType.Success(locations))
                        }
                    }
                }
            }

            override fun cancel() {
                networkCall?.cancel()
            }
        }
    }
}
