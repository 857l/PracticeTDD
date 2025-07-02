package com.github.johnnysc.practicetdd

class LifoStack<T>(
    maxCount: Int
) : BaseStack<T>(maxCount) {

    override fun removeItem(): T {
        return items.removeAt(items.size - 1)
    }

}
