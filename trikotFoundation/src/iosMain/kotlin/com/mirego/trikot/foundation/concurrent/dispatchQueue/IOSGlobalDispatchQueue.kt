package com.mirego.trikot.foundation.concurrent.dispatchQueue

import com.mirego.trikot.foundation.FoundationConfiguration
import com.mirego.trikot.foundation.concurrent.freeze
import platform.darwin.DISPATCH_QUEUE_PRIORITY_HIGH
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_global_queue
import platform.darwin.dispatch_get_main_queue

open class IOSGlobalDispatchQueue : TrikotDispatchQueue {
    override fun isSerial() = false

    override fun dispatch(block: DispatchBlock) {
        freeze(block)

        dispatch_async(
            dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_HIGH.toLong(), 0UL),
            freeze {
                try {
                    runQueueTask(block)
                } catch (e: Throwable) {
                    forwardExceptionOnMainThread(e)
                }
            }
        )
    }

    private fun runQueueTask(block: DispatchBlock) {
        block()
    }

    private fun forwardExceptionOnMainThread(exception: Throwable) {
        if (!FoundationConfiguration.forwardsExceptionsOnMainThread) return

        dispatch_async(dispatch_get_main_queue()) {
            throw RuntimeException(exception)
        }
    }
}
