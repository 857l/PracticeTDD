package com.github.johnnysc.practicetdd

interface Parser {
    fun parse(raw: String): List<Any>

    class Base(
        private val delimiter: String
    ) : Parser {

        private val typeParsers: List<TypeParsers> = listOf(
            ByteParser(),
            ShortParser(),
            IntParser(),
            LongParser(),
            FloatParser(),
            DoubleParser(),
            BooleanParser(),
            CharParser(),
            StringParser()
        )

        init {
            if (delimiter == "") throw IllegalStateException("delimiter is empty")
        }

        override fun parse(raw: String): List<Any> {
            if (raw.isBlank()) return emptyList()
            val parts = raw.split(delimiter)
            return parts.mapNotNull { parseValue(it.trim()) }
        }

        private fun parseValue(value: String): Any? {
            for (parser in typeParsers) {
                val result = parser.parse(value)
                if (result != null) return result
            }
            return null
        }

    }

}