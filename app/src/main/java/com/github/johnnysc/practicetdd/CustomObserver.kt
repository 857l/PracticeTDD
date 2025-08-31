package com.github.johnnysc.practicetdd

interface CustomObserver <T : Any> {

    fun update(argument: T)
}