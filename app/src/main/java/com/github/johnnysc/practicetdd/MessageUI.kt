package com.github.johnnysc.practicetdd

interface MessageUI {

    fun copyWithId(id: String): MessageUI

    data class User(
        private val text: String,
        private val id: String = "0"
    ) : MessageUI {
        override fun copyWithId(id: String) = copy(id = id)
    }

    data class AiError(
        private val text: String,
        private val id: String = "0"
    ) : MessageUI {
        override fun copyWithId(id: String) = copy(id = id)
    }

    data class Ai(
        private val text: String,
        private val id: String = "0"
    ) : MessageUI {
        override fun copyWithId(id: String) = copy(id = id)
    }

    data class Empty(
        private val text: String = "",
        private val id: String = ""
    ) : MessageUI {
        override fun copyWithId(id: String) = copy(id = id)
    }
}