package com.mirego.trikot.foundation.concurrent.dispatchQueue

import com.mirego.trikot.foundation.concurrent.AtomicListReference
import com.mirego.trikot.foundation.concurrent.AtomicReference
import com.mirego.trikot.foundation.concurrent.freeze

/**
 * Ensure dispatch blocks are executed sequentially on a dispatch queue.
 */
open class SequentialDispatchQueue(override val dispatchQueue: TrikotDispatchQueue) :
    TrikotQueueDispatcher,
    TrikotDispatchQueue {
    private val dispatchBlockQueue = AtomicListReference<DispatchBlock>()
    private val currentDispatch = AtomicReference(NoDispatchBlock)

    override fun isSerial() = true

    override fun dispatch(block: DispatchBlock) {
        dispatchBlockQueue.add(block)
        startNextIfNeeded()
    }

    private fun startNextIfNeeded() {
        dispatchBlockQueue.value.firstOrNull()?.let { nextDispatchBlock ->
            if (currentDispatch.compareAndSet(NoDispatchBlock, nextDispatchBlock)) {
                dispatchBlockQueue.remove(nextDispatchBlock)
                (this as TrikotQueueDispatcher).dispatch {
                    nextDispatchBlock()
                    markDispatchBlockCompleted(nextDispatchBlock)
                    startNextIfNeeded()
                }
            }
        }
    }

    private fun markDispatchBlockCompleted(block: DispatchBlock) {
        currentDispatch.setOrThrow(block, NoDispatchBlock)
    }

    companion object {
        private val NoDispatchBlock = freeze {}
    }
}
