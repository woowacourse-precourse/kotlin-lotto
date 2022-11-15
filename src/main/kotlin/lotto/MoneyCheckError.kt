package lotto

class MoneyCheckError(private val userInput: String) {
    fun checkMoneyThrowException() {
        throwIsMoneyNumberException(userInput)
        throwMoneyUnitException(userInput)
    }

    private fun throwIsMoneyNumberException(userInput: String) {
        val numbers = userInput.toCharArray().filter { number ->
            number in '0'..'9'
        }
        if (numbers.size != userInput.length) {
            println("[ERROR] 구입 금액은 숫자여야 합니다.")
            throw IllegalArgumentException()
        }
    }

    private fun throwMoneyUnitException(userInput: String) {
        if (userInput.toInt() % LOTTO_PRICE != 0) {
            println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.")
            throw IllegalArgumentException()
        }
    }
}
