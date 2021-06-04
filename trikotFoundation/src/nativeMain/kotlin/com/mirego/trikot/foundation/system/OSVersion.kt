package com.mirego.trikot.foundation.system

import kotlinx.cinterop.CValue
import kotlinx.cinterop.cValue
import platform.Foundation.NSOperatingSystemVersion
import platform.Foundation.NSProcessInfo

@Suppress("EnumEntryName")
enum class OSVersion(val majorVersion: Int, val minorVersion: Int, val patchVersion: Int) {
    iOS_10(majorVersion = 10, minorVersion = 0, patchVersion = 0),
    iOS_11(majorVersion = 11, minorVersion = 0, patchVersion = 0),
    iOS_12(majorVersion = 12, minorVersion = 0, patchVersion = 0),
    iOS_13(majorVersion = 13, minorVersion = 0, patchVersion = 0),
    iOS_14(majorVersion = 14, minorVersion = 0, patchVersion = 0),
    tvOS_10(majorVersion = 10, minorVersion = 0, patchVersion = 0),
    tvOS_11(majorVersion = 11, minorVersion = 0, patchVersion = 0),
    tvOS_12(majorVersion = 12, minorVersion = 0, patchVersion = 0),
    tvOS_13(majorVersion = 13, minorVersion = 0, patchVersion = 0),
    tvOS_14(majorVersion = 14, minorVersion = 0, patchVersion = 0),
    watchOS_3(majorVersion = 3, minorVersion = 0, patchVersion = 0),
    watchOS_4(majorVersion = 4, minorVersion = 0, patchVersion = 0),
    watchOS_5(majorVersion = 5, minorVersion = 0, patchVersion = 0),
    watchOS_6(majorVersion = 6, minorVersion = 0, patchVersion = 0),
    watchOS_7(majorVersion = 7, minorVersion = 0, patchVersion = 0),
    macOS_10_12(majorVersion = 10, minorVersion = 12, patchVersion = 0),
    macOS_10_13(majorVersion = 10, minorVersion = 13, patchVersion = 0),
    macOS_10_14(majorVersion = 10, minorVersion = 14, patchVersion = 0),
    macOS_10_15(majorVersion = 10, minorVersion = 15, patchVersion = 0),
    macOS_11(majorVersion = 11, minorVersion = 0, patchVersion = 0);

    val platform: OSPlatform
        get() = when (this) {
            iOS_10,
            iOS_11,
            iOS_12,
            iOS_13,
            iOS_14 -> OSPlatform.iOS
            tvOS_10,
            tvOS_11,
            tvOS_12,
            tvOS_13,
            tvOS_14 -> OSPlatform.tvOS
            watchOS_3,
            watchOS_4,
            watchOS_5,
            watchOS_6,
            watchOS_7 -> OSPlatform.watchOS
            macOS_10_12,
            macOS_10_13,
            macOS_10_14,
            macOS_10_15,
            macOS_11 -> OSPlatform.macOS
        }

    val operatingSystemVersion: CValue<NSOperatingSystemVersion>
        get() = cValue<NSOperatingSystemVersion> {
            majorVersion = majorVersion
            minorVersion = minorVersion
            patchVersion = patchVersion
        }
}

fun osVersionAtLeast(vararg versions: OSVersion): Boolean {
    return versions.filter { it.platform == currentPlatform }.any {
        NSProcessInfo.processInfo.isOperatingSystemAtLeastVersion(it.operatingSystemVersion)
    }
}
