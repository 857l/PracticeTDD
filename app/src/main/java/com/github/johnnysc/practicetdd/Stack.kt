package com.github.johnnysc.practicetdd

interface Stack<T> {
    fun pop(): T
    fun push(item: T)
}