package com.github.johnnysc.practicetdd

interface Count {

    fun increment(m: MessageUI): MessageUI

    class Base() : Count {

        private var count: Int = 0

        override fun increment(message: MessageUI): MessageUI =
            message.copyWithId((count++).toString())
    }
}