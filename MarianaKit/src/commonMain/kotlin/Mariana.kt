package com.marianatek.marianakit

import com.marianatek.marianakit.apiclient.MarianaApiImpl
import com.marianatek.marianakit.data.LocationData
import com.marianatek.marianakit.data.LocationDataImpl

class Mariana : LocationData by LocationDataImpl(MarianaApiImpl())
