package com.github.johnnysc.practicetdd

interface CustomObservable<T : Any, E : CustomObserver<T>> : CustomObserver<T> {

    fun addObserver(observer: E)

    fun removeObserver(observer: E)

    class Base<T : Any, E : CustomObserver<T>>(
        private val maxCount : Int
    ) : CustomObservable<T, E> {

        private val observerList : MutableList<E> = mutableListOf()

        override fun addObserver(observer: E) {
            observerList.add(observer)
        }

        override fun removeObserver(observer: E) {
            observerList.remove(observer)
        }

        override fun update(argument: T) {
            observerList.lastOrNull()?.update(argument)
        }
    }
}