package com.mirego.trikot.foundation.concurrent.dispatchQueue

import com.mirego.trikot.foundation.concurrent.freeze
import platform.darwin.DISPATCH_QUEUE_PRIORITY_HIGH
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_global_queue

open class IOSGlobalDispatchQueue : TrikotDispatchQueue {
    private val globalQueue = dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_HIGH.toLong(), 0UL)

    override fun isSerial() = false

    override fun dispatch(block: DispatchBlock) {
        freeze(block)

        dispatch_async(
            globalQueue,
            freeze {
                runQueueTask(block)
            }
        )
    }

    private fun runQueueTask(block: DispatchBlock) {
        try {
            block()
        } catch (e: Throwable) {
            forwardExceptionOnMainThread(e)
        }
    }
}
