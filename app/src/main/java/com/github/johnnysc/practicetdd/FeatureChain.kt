package com.github.johnnysc.practicetdd

interface FeatureChain {

    interface CheckAndHandle : Check, Handle

    interface Check {
        fun canHandle(message: String): Boolean
    }

    interface Handle {
        suspend fun handle(message: String): MessageUI
    }

    object Empty : Handle {
        override suspend fun handle(message: String): MessageUI =
            MessageUI.Empty()
    }
}