package com.github.johnnysc.practicetdd

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface MessagesCommunication {

    interface Map : com.github.johnnysc.practicetdd.Map<MessageUI>

    interface Observe: com.github.johnnysc.practicetdd.Observe<MessageUI>

    interface Mutable : Map, Observe
}

interface Map<T> {
    fun map(data: T)
}

interface Observe<T>{
    fun observe(owner: LifecycleOwner, observer: Observer<List<T>>) = Unit
}