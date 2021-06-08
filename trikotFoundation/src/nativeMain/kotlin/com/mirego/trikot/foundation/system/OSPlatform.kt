package com.mirego.trikot.foundation.system

enum class OSPlatform {
    iOS,
    tvOS,
    watchOS,
    macOS
}

expect object CurrentPlatform {
    val current: OSPlatform
}
