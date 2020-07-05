package com.marianatek.marianakit.apiclient

sealed class ResultType<T> {
    data class Success<Data : Any>(val data: Data) : ResultType<Data>()
    data class Failure<Data : Any>(val throwable: Throwable) : ResultType<Data>()
}
