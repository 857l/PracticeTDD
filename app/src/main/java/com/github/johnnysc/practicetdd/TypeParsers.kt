package com.github.johnnysc.practicetdd

interface TypeParsers {
    fun parse(value: String): Any?
}

class BooleanParser() : TypeParsers {
    override fun parse(value: String): Any? {
        return when (value) {
            "true" -> true
            "false" -> false
            else -> null
        }
    }
}

class CharParser() : TypeParsers {
    override fun parse(value: String): Any? {
        return if (value.length == 1) value[0] else null
    }
}

class ByteParser() : TypeParsers {
    override fun parse(value: String): Any? = value.toByteOrNull()
}

class ShortParser() : TypeParsers {
    override fun parse(value: String): Any? = value.toShortOrNull()
}

class IntParser() : TypeParsers {
    override fun parse(value: String): Any? = value.toIntOrNull()
}

class LongParser() : TypeParsers {
    override fun parse(value: String): Any? = value.toLongOrNull()
}

class FloatParser() : TypeParsers {
    override fun parse(value: String): Any? = value.toFloatOrNull()
}

class DoubleParser() : TypeParsers {
    override fun parse(value: String): Any? = value.toDoubleOrNull()
}

class StringParser() : TypeParsers {
    override fun parse(value: String): Any = value
}