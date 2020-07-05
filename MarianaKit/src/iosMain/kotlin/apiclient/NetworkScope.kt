package com.marianatek.marianakit.apiclient

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual class NetworkScope actual constructor(coroutineScope: CoroutineScope)
    : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}
