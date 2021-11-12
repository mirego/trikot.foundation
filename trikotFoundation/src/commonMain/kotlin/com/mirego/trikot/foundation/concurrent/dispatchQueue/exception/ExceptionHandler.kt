package com.mirego.trikot.foundation.concurrent.dispatchQueue.exception

interface TrikotDispatchQueueExceptionHandler {
    fun handle(throwable: Throwable)
}

interface BackgroundQueueExceptionHandler : TrikotDispatchQueueExceptionHandler
