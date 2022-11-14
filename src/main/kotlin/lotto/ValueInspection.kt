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


}

const val ERROR_MESSAGE_ONLY_NUMBER = "[ERROR] 숫자만 입력할 수 있습니다."
const val ERROR_MESSAGE_ONLY_UNIT_1000 = "[ERROR] 1000원 단위의 금액만 지불이 가능합니다."