package com.mirego.trikot.foundation.concurrent.dispatchQueue

actual class OperationDispatchQueue : ExecutorDispatchQueue(), TrikotDispatchQueue

@Deprecated("Streams subscription concurrency is now handled by a serial queue in PublishSubject")
actual class SerialSubscriptionDispatchQueue : ExecutorDispatchQueue(1), TrikotDispatchQueue
