package com.mirego.trikot.foundation.concurrent.dispatchQueue

import com.mirego.trikot.foundation.concurrent.freeze
import kotlin.native.concurrent.AtomicInt
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_global_queue
import platform.darwin.DISPATCH_QUEUE_PRIORITY_HIGH

open class iOSDispatchQueue(private val maxConcurrentOperation: Long = 4) : DispatchQueue {
    private val count = AtomicInt(0)

    override fun isSerial() = true

    override fun dispatch(block: DispatchBlock) {
        freeze(block)

        dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_HIGH, 0), freeze {
            runQueueTask(block)
        })
    }

    private fun runQueueTask(block: DispatchBlock) {
        block()
        count.decrement()
    }
}
