package domain

import values.*

class Inspection {

    fun price(input: String) {
        if (input.any { it !in '0'..'9' }) {
            println(ERROR_MESSAGE_ONLY_NUMBER)
            throw IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBER)
        }
        else if (input.toInt() % 1000 != 0) {
            println(ERROR_MESSAGE_ONLY_UNIT_1000)
            throw IllegalArgumentException(ERROR_MESSAGE_ONLY_UNIT_1000)
        }
    }

    fun jackpot(input: String) {
        val jackpotList: List<Int> = input.split(",").map { it.toInt() }
        if (!input.contains(",")) {
            println(ERROR_MESSAGE_INPUT_FORMAT)
            throw IllegalArgumentException(ERROR_MESSAGE_INPUT_FORMAT)
        }
        if (jackpotList.all { it !in 1..45 }) {
            println(ERROR_MESSAGE_NUMBER_OUT_RANGE)
            throw IllegalArgumentException(ERROR_MESSAGE_NUMBER_OUT_RANGE)
        }
        if (jackpotList.size != 6) {
            println(ERROR_MESSAGE_ONLY_SIX_NUMBER)
            throw IllegalArgumentException(ERROR_MESSAGE_ONLY_SIX_NUMBER)
        }
    }

    fun bonus(input: String) {
        if (input.all { it !in '0'..'9' }) {
            println(ERROR_MESSAGE_ONLY_NUMBER)
            throw IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBER)
        }
        if (input.toInt() !in 1..45) {
            println(ERROR_MESSAGE_NUMBER_OUT_RANGE)
            throw IllegalArgumentException(ERROR_MESSAGE_NUMBER_OUT_RANGE)
        }
    }

}
