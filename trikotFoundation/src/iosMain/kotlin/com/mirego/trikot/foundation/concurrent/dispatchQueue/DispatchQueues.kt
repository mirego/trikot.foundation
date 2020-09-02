package com.mirego.trikot.foundation.concurrent.dispatchQueue

actual class OperationDispatchQueue : IOSGlobalDispatchQueue(), DispatchQueue

actual class SerialSubscriptionDispatchQueue : IOSSerialDispatchQueue("serialSubscriptionQueue"), DispatchQueue
