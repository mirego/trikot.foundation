package com.mirego.trikot.foundation.concurrent.dispatchQueue.exception

import com.mirego.trikot.foundation.concurrent.freeze
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

open class ThrowOnMainQueueExceptionHandler : BackgroundQueueExceptionHandler {
    override fun handle(throwable: Throwable) {
        freeze(throwable)

        dispatch_async(
            dispatch_get_main_queue(),
            freeze { throw throwable }
        )
    }
}
