package com.mirego.trikot.foundation.concurrent.dispatchQueue

import com.mirego.trikot.foundation.FoundationConfiguration
import java.util.concurrent.Executors

open class ExecutorDispatchQueue(private val maxConcurrentOperation: Int = 4) :
    TrikotDispatchQueue {

    private var pool = Executors.newFixedThreadPool(maxConcurrentOperation)

    override fun isSerial() = maxConcurrentOperation == 1

    override fun dispatch(block: DispatchBlock) = pool.execute {
        runQueueTask(block)
    }

    private fun runQueueTask(block: DispatchBlock) {
        try {
            block()
        } catch (e: Throwable) {
            FoundationConfiguration.backgroundQueueExceptionHandler.handle(e)
        }
    }
}
