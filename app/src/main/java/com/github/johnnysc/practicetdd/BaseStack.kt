package com.github.johnnysc.practicetdd

abstract class BaseStack<T>(
    private val maxCount: Int
) : Stack<T> {
    protected val items = mutableListOf<T>()

    init {
        if (maxCount <= 0) throw IllegalStateException("maxCount must be > 0")
    }

    override fun push(item: T) {
        if (items.size >= maxCount) {
            throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
        }
        items.add(item)
    }

    override fun pop(): T {
        if (items.isEmpty()) {
            throw IllegalStateException("Cannot pop from empty stack")
        }
        return removeItem()
    }

    protected abstract fun removeItem(): T

}