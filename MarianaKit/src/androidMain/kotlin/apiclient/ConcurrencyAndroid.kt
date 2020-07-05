package com.marianatek.marianakit.apiclient

actual suspend fun <R> network(block: suspend () -> R): R = block()
