package lotto

import camp.nextstep.edu.missionutils.Console

class LottoCustomer {
    fun customerLottoBuyPriceInput(): Int {
        println(LottoProcessStatement.INPUT_LOTTO_BUY_PRICE)
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

        if ((userInput.toInt() % 1000) == 0) {
            return false
        }

        return true
    }

    companion object {
        const val CUSTOMER_BUY_PRICE_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 단위의 정수여야 합니다."
    }
}