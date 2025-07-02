package com.github.johnnysc.practicetdd

object MyStack {

    fun <T> LIFO(maxCount: Int): Stack<T> = LifoStack(maxCount)

    fun <T> FIFO(maxCount: Int): Stack<T> = FifoStack(maxCount)
}