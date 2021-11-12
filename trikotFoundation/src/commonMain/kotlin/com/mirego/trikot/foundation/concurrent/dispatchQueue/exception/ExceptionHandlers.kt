package com.mirego.trikot.foundation.concurrent.dispatchQueue.exception

expect class DefaultBackgroundQueueExceptionHandler() : BackgroundQueueExceptionHandler

open class NoBackgroundQueueExceptionHandler : BackgroundQueueExceptionHandler {
    override fun handle(throwable: Throwable) = throw throwable
}
