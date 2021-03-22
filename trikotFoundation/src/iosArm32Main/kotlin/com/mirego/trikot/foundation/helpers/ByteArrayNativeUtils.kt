package com.mirego.trikot.foundation.helpers

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.get
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.create

object ByteArrayNativeUtils {
    @ExperimentalUnsignedTypes
    fun convert(data: NSData): ByteArray {
        val dataPointer: CPointer<ByteVar> = data.bytes!!.reinterpret()
        return ByteArray(data.length.toInt()) { index -> dataPointer[index] }
    }
    @ExperimentalUnsignedTypes
    fun convert(byteArray: ByteArray): NSData {
        return byteArray.usePinned {
            NSData.create(
                bytes = it.addressOf(0),
                length = byteArray.size.toUInt()
            )
        }
    }
}
