package com.github.johnnysc.practicetdd

class FifoStack<T>(
    maxCount: Int
) : BaseStack<T>(maxCount) {

    override fun removeItem(): T {
        return items.removeAt(0)
    }

}
