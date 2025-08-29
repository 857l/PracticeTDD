package com.github.johnnysc.practicetdd

interface Factorial<T : Number> {

    fun value(number: T): T

    class Int() : Factorial<kotlin.Int> {

        override fun value(number: kotlin.Int): kotlin.Int {
            return if (number == 0) 1 else number * value(number - 1)
        }
    }

    class Double() : Factorial<kotlin.Double> {

        override fun value(number: kotlin.Double): kotlin.Double {
            return if (number == 0.0) 1.0 else number * value(number - 1)
        }
    }

    class BigInteger() : Factorial<java.math.BigInteger> {

        override fun value(number: java.math.BigInteger): java.math.BigInteger {
            return if (number <= java.math.BigInteger.ZERO) java.math.BigInteger.ONE else number * value(number - java.math.BigInteger.ONE)
        }
    }

    class Factory(
        private val int: Factorial<kotlin.Int>,
        private val double: Factorial<kotlin.Double>,
        private val bigInteger: Factorial<java.math.BigInteger>
    ) : Factorial<Number> {

        override fun value(number: Number): Number =
            when {
                (number.toInt() < 0) -> throw IllegalArgumentException("value")
                (number.toInt() <= 12) -> int.value(number.toInt())
                (number.toDouble() <= 170) -> double.value(number.toDouble())
                (number.toLong() <= 11000) -> bigInteger.value(java.math.BigInteger.valueOf(number.toLong()))
                else -> throw IllegalStateException("value")
            }
    }
}