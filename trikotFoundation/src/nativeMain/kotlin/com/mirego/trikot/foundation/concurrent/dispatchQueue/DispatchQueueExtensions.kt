package com.mirego.trikot.foundation.concurrent.dispatchQueue

import com.mirego.trikot.foundation.FoundationConfiguration
import com.mirego.trikot.foundation.concurrent.freeze
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

@Suppress("unused")
fun TrikotDispatchQueue.forwardExceptionOnMainThread(exception: Throwable) {
    if (!FoundationConfiguration.forwardsExceptionsOnMainThread) return

    freeze(exception)

    dispatch_async(
        dispatch_get_main_queue(),
        freeze { throw exception }
    )
}
