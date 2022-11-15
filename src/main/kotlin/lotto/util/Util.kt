package lotto.util

fun throwException(message: String) {
    println(message)
    throw IllegalArgumentException(message)
}
