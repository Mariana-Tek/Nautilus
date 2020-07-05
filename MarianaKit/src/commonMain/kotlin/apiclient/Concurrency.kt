package com.marianatek.marianakit.apiclient

internal expect suspend fun <R> network(block: suspend () -> R): R
