package com.mirego.trikot.foundation.concurrent.dispatchQueue

actual class OperationDispatchQueue : iOSGlobalDispatchQueue(), DispatchQueue

actual class SerialSubscriptionDispatchQueue : iOSSerialDispatchQueue("serialSubscriptionQueue"), DispatchQueue
