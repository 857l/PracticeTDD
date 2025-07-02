package com.github.johnnysc.practicetdd

interface Parser {

    fun parse(raw: String)

    class Base(
        delimiter: String
    ) : Parser {

        override fun parse(raw: String) {
            TODO("Not yet implemented")
        }

    }
}