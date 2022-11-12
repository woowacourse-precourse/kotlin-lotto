package lotto

import utils.Constants

class Rule {
    fun checkPurchaseAmount(amount: String) {
        // 1. 숫자 외 문자일 경우
        val amountNumber = amount.toIntOrNull() ?:
        throw IllegalArgumentException(Constants.ERROR_MESSAGE_OUT_OF_RANGE)

        // 2. 1000원 단위인지
        if (amountNumber % 1000 != 0)
            throw IllegalArgumentException(Constants.ERROR_MESSAGE_NOT_1000WON)
    }

}