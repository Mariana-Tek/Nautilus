package com.marianatek.marianakit.apiclient

import kotlinx.coroutines.CoroutineScope

actual class NetworkScope actual constructor(coroutineScope: CoroutineScope)
    : CoroutineScope by coroutineScope
