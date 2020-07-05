package com.marianatek.marianakit.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegionsResult(
        @SerialName("results") val regions: List<Region>,
        @SerialName("meta") val paginationMeta: PaginationMeta,
        val links: Links
)

@Serializable
data class LocationsResult(
        @SerialName("results") val locations: List<Location>,
        @SerialName("meta") val paginationMeta: PaginationMeta,
        val links: Links
)

@Serializable
data class Region(
        val id: String,
        val name: String?,
        val locations: List<Location> = emptyList()
)

@Serializable
data class Location(
        val id: String,
        val name: String?,
        val timezone: String?,
        val city: String?,
        val description: String?,
        val email: String?,
        @SerialName("address_line_one") val addressLine1: String?,
        @SerialName("address_line_two") val addressLine2: String?,
        @SerialName("payment_gateway_type") val paymentGatewayType: String?,
        @SerialName("phone_number") val phoneNumber: String?,
        @SerialName("postal_code") val postalCode: String?,
        @SerialName("state_province") val stateProvince: String?,
        @SerialName("region") val regionResponse: Region?
)
