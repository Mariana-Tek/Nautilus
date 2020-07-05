package com.marianatek.marianakit.models

import kotlinx.serialization.Serializable

@Serializable
data class Instructor(
        val id : String,
        val bio : String,
        val name : String,
        val largeUrl : String?,
        val thumbnailUrl : String?
)
