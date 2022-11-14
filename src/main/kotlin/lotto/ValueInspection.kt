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

const val ERROR_MESSAGE_ONLY_NUMBER = "[ERROR] 숫자만 입력할 수 있습니다."
const val ERROR_MESSAGE_ONLY_SIX_NUMBER = "[ERROR] 6개의 숫자만 입력할 수 있습니다."
const val ERROR_MESSAGE_NUMBER_OUT_RANGE = "[ERROR] 1~45 범위의 숫자만 입력할 수 있습니다."
const val ERROR_MESSAGE_INPUT_FORMAT = "[ERROR] 입력 형식이 잘못되었습니다."
const val ERROR_MESSAGE_ONLY_UNIT_1000 = "[ERROR] 1000원 단위의 금액만 지불이 가능합니다."