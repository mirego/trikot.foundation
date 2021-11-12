package com.mirego.trikot.foundation.concurrent.dispatchQueue.exception

actual class DefaultBackgroundQueueExceptionHandler :
    ThrowOnMainQueueExceptionHandler(),
    BackgroundQueueExceptionHandler
