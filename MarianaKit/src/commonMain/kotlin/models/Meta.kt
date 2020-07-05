package com.marianatek.marianakit.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface ResponseMeta<T> {
    val meta: T
}

@Serializable
data class PaginationMeta(@SerialName("pagination") override val meta: Pagination)
    : ResponseMeta<Pagination>

@Serializable
data class Pagination(val page: Int, val pages: Int, val count: Int)

@Serializable
data class Links(val first: String?, val last: String?, val next: String?, val prev: String?)
