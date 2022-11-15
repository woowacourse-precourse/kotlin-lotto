package lotto.utils

import lotto.utils.Constants.LottoPrice

enum class ErrorMessage(val messages: String) {
    ERROR("[ERROR] 에러가 발생했습니다."),
    ERROR_PRICE("[ERROR] 티켓 가격이 아닙니다."),
    ERROR_NUMBER_TYPE("[ERROR] 숫자가 아닙니다.")
}

class ErrorCheck() {
    fun errorPrice(buyPrice: Int) {
        if (buyPrice % LottoPrice != 0) {
            throw IllegalArgumentException(ErrorMessage.ERROR_PRICE.messages)
        }
    }
    fun errorString(input: String) {
        try {
            input.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ErrorMessage.ERROR_NUMBER_TYPE.messages)
        }
    }
}