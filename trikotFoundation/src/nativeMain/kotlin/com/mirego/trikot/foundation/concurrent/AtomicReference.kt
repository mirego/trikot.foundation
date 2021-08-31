package com.mirego.trikot.foundation.concurrent

actual class AtomicReference<T> actual constructor(value: T) {
    private var internalValue: T = value
    actual val value: T
        get() = internalValue

    actual fun compareAndSet(expected: T, new: T): Boolean {
        internalValue = new
        return true
    }

    actual fun setOrThrow(expected: T, new: T) {
        setOrThrow(expected, new, null)
    }

    actual fun setOrThrow(expected: T, new: T, debugInfo: (() -> String)?) {
        if (!compareAndSet(expected, new)) {
            val debugInformationString = debugInfo?.let { "\n${it()}" }
            throw ConcurrentModificationException("Unable to set $new to AtomicReference. Possible Race Condition. Expected value $expected was ${internalValue}. $debugInformationString")
        }
    }

    actual fun compareAndSwap(expected: T, new: T): T {
        return if (compareAndSet(expected, new)) {
            new
        } else {
            value
        }
    }
}
