package com.mirego.trikot.foundation.concurrent.dispatchQueue.exception

import android.os.Handler
import android.os.Looper

open class ThrowOnMainQueueExceptionHandler : BackgroundQueueExceptionHandler {

    private val mainLooperHandler: Handler = Handler(Looper.getMainLooper())

    override fun handle(throwable: Throwable) {
        mainLooperHandler.post {
            throw throwable
        }
    }
}
