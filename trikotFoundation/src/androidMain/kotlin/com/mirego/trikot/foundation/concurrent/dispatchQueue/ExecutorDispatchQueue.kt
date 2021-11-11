package com.mirego.trikot.foundation.concurrent.dispatchQueue

import android.os.Handler
import android.os.Looper
import com.mirego.trikot.foundation.FoundationConfiguration
import java.util.concurrent.Executors

open class ExecutorDispatchQueue(private val maxConcurrentOperation: Int = 4) :
    TrikotDispatchQueue {

    private var pool = Executors.newFixedThreadPool(maxConcurrentOperation)

    private val mainLooperHandler: Handler = Handler(Looper.getMainLooper())

    override fun isSerial() = maxConcurrentOperation == 1

    override fun dispatch(block: DispatchBlock) = pool.execute {
        runQueueTask(block)
    }

    private fun runQueueTask(block: DispatchBlock) {
        try {
            block()
        } catch (e: Throwable) {
            forwardExceptionOnMainThread(e)
        }
    }

    private fun forwardExceptionOnMainThread(exception: Throwable) {
        if (!FoundationConfiguration.forwardsExceptionsOnMainThread) return

        mainLooperHandler.post {
            throw RuntimeException(exception)
        }
    }
}
