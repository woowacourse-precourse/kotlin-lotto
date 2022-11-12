package lotto

class Money(private val money: String) {
    init {
        require(isNumber()) { println(IS_NUMBER) }
        require(canDividedMoney()) { println(DIVIDED_MONEY) }
    }

    private fun isNumber(): Boolean =
        money.all { number ->
            number.isDigit()
        }

    private fun canDividedMoney(): Boolean =
        money.toInt() % 1000 == 0

    companion object {
        private const val IS_NUMBER = "[ERROR] 금액은 숫자이여야 합니다."
        private const val DIVIDED_MONEY = "[ERROR] 1000원 단위로 나누어 떨어져야 합니다."
    }
}