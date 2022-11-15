package domain

import values.*

class Inspection {

    fun price(input: String) {
        if (input.any { it !in '0'..'9' }) {
            throw IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBER)
        }
        if (input.toInt() % 1000 != 0) {
            throw IllegalArgumentException(ERROR_MESSAGE_ONLY_UNIT_1000)
        }
    }

    fun jackpot(input: String) {
        val jackpotList: List<Int> = input.split(",").map { it.toInt() }
        if (!input.contains(",")) {
            throw IllegalArgumentException(ERROR_MESSAGE_INPUT_FORMAT)
        }
        if (jackpotList.all { it !in 1..45 }) {
            throw IllegalArgumentException(ERROR_MESSAGE_NUMBER_OUT_RANGE)
        }
        if (jackpotList.size != 6) {
            throw IllegalArgumentException(ERROR_MESSAGE_ONLY_SIX_NUMBER)
        }
    }

    fun bonus(input: String) {
        if (input.all { it !in '0'..'9' }) {
            throw IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBER)
        }
        if (input.toInt() !in 1..45) {
            throw IllegalArgumentException(ERROR_MESSAGE_NUMBER_OUT_RANGE)
        }
    }

}
