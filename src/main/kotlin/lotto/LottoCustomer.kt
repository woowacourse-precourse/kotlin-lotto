package lotto

import camp.nextstep.edu.missionutils.Console

class LottoCustomer {
    fun customerLottoBuyPriceInput(): Int {
        val userInput = Console.readLine()
        if (customerPriceInputIsValid(userInput)) {
            throw IllegalArgumentException(CUSTOMER_BUY_PRICE_ERROR_MESSAGE)
        }

        return userInput.toInt()
    }
    private fun customerPriceInputIsValid(userInput: String?): Boolean {
        if (userInput.isNullOrBlank()) {
            return false
        }

        if ((userInput.toInt() % LottoProcessConstValue.LOTTO_UNIT_PRICE) == 0) {
            return false
        }

        return true
    }



    companion object {
        const val CUSTOMER_BUY_PRICE_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 단위의 정수여야 합니다."
    }
}