package com.marianatek.marianakit.data

import com.marianatek.marianakit.apiclient.ResultType

interface Call<Data: Any> {
    fun get(completion: Completion<Data>)
    fun cancel()
}

typealias Completion<Data> = (ResultType<Data>) -> Unit
