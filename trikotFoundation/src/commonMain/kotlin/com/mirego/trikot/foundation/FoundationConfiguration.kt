package com.mirego.trikot.foundation

import com.mirego.trikot.foundation.concurrent.AtomicReference
import com.mirego.trikot.foundation.concurrent.atomic
import com.mirego.trikot.foundation.concurrent.dispatchQueue.exception.BackgroundQueueExceptionHandler
import com.mirego.trikot.foundation.concurrent.dispatchQueue.exception.DefaultBackgroundQueueExceptionHandler
import com.mirego.trikot.foundation.timers.DefaultTimerFactory
import com.mirego.trikot.foundation.timers.TimerFactory
import kotlin.time.ExperimentalTime

@ExperimentalTime
object FoundationConfiguration {
    private val internalTimerFactoryRef = AtomicReference<TimerFactory>(DefaultTimerFactory())

    var timerFactory: TimerFactory
        get() = internalTimerFactoryRef.value
        set(value) = internalTimerFactoryRef.setOrThrow(internalTimerFactoryRef.value, value)

    var backgroundQueueExceptionHandler: BackgroundQueueExceptionHandler by atomic(
        DefaultBackgroundQueueExceptionHandler()
    )
}
