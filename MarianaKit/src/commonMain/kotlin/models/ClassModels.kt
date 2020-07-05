package com.marianatek.marianakit.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClassSessionResults(
        val results: List<ClassSession>,
        @SerialName("meta") val paginationMeta: PaginationMeta
)

@Serializable
data class ClassSession(
        val id: String,
        val capacity: Int?,
        val instructors: List<Instructor>,
        val location: Location?,
        val name: String?,
        val status: String?,
        val layout: Layout?,
        @SerialName("available_spot_count") val available_spot_count: Int?,
        @SerialName("booking_start_datetime") val booking_start_datetime: String?,
        @SerialName("class_type") val class_type: ClassType?,
        @SerialName("classroom_name") val classroom_name: String?,
        @SerialName("is_cancelled") val is_cancelled: Boolean?,
        @SerialName("is_user_guest_reserved") val is_user_guest_reserved: Boolean?,
        @SerialName("is_user_reserved") val is_user_reserved: Boolean?,
        @SerialName("is_user_waitlisted") val is_user_waitlisted: Boolean?,
        @SerialName("layout_format") val layout_format: String?,
        @SerialName("start_date") val start_date: String?,
        @SerialName("start_time") val start_time: String?,
        @SerialName("start_datetime") val start_datetime: String?,
        @SerialName("spot_options") val spot_options: SpotOptions?,
        @SerialName("waitlist_count") val waitlist_count: Int?
)

@Serializable
data class ClassType(
        val id: String,
        val description: String?,
        val duration: Int?,
        val name: String?,
        @SerialName("is_live_stream") val isLiveStream: Boolean?,
        @SerialName("duration_formatted") val durationFormatted: String?
)

@Serializable
data class Layout(
        val id: String,
        val name: String?,
        val spots: List<Spot>
)

@Serializable
data class Spot(
        val id: String,
        val name: String?,
        @SerialName("spot_type") val spotType: SpotType?,
        @SerialName("x_position") val xPosition: Float?,
        @SerialName("y_position") val yPosition: Float?,
        @SerialName("is_available") val isAvailable: Boolean?
)

@Serializable
data class SpotType(
        val id: String,
        val name: String?,
        @SerialName("is_primary") val isPrimary: Boolean?
)

@Serializable
data class SpotOptions(
        @SerialName("primary_availability") val primaryAvailability: Int = 0,
        @SerialName("primary_capacity") val primaryCapacity: Int = 0,
        @SerialName("secondary_availability") val secondaryAvailability: Int = 0,
        @SerialName("secondary_capacity") val secondaryCapacity: Int = 0,
        @SerialName("standby_availability") val standbyAvailability: Int = 0,
        @SerialName("standby_capacity") val standbyCapacity: Int = 0,
        @SerialName("waitlist_availability") val waitListAvailability: Int? = null,
        @SerialName("waitlist_capacity") val waitListCapacity: Int? = null
)
