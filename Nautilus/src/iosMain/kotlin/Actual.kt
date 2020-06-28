package com.marianatek.nautilus

import platform.UIKit.UIDevice

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
        " " +
        UIDevice.currentDevice.systemVersion
}