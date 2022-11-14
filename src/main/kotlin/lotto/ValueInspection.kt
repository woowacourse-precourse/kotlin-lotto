package lotto

class ValueInspection {

    fun price(input: String): Boolean {
        if (input.all { it !in '0'..'9' }) {
            IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBER)
        }
        if (input.toInt() % 1000 != 0) {
            IllegalArgumentException(ERROR_MESSAGE_ONLY_UNIT_1000)
        }
        return true
    }

    fun jackpot(input: String): Boolean {
        val jackpotList: List<Int> = input.split(",").map { it.toInt() }
        if (!input.contains(",")) {
            IllegalArgumentException(ERROR_MESSAGE_INPUT_FORMAT)
        }
        if (jackpotList.all { it !in 1..45 }) {
            IllegalArgumentException(ERROR_MESSAGE_NUMBER_OUT_RANGE)
        }
        if (jackpotList.size != 6) {
            IllegalArgumentException(ERROR_MESSAGE_ONLY_SIX_NUMBER)
        }
        return true
    }

    fun bonus(input: String): Boolean {
        if (input.all { it !in '0'..'9' }) {
            IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBER)
        }
        if (input.toInt() !in 1..45) {
            IllegalArgumentException(ERROR_MESSAGE_NUMBER_OUT_RANGE)
        }
        return true
    }

}
