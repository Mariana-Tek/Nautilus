package com.marianatek.marianakit.apiclient

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope

expect class NetworkScope(coroutineScope: CoroutineScope = GlobalScope): CoroutineScope
