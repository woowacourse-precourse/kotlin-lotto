package lotto

class Money(private val money: String) {
    init {
        require(isNumber()) { println(IS_NUMBER) }
    }

    private fun isNumber(): Boolean =
        money.all { number ->
            number.isDigit()
        }

    companion object {
        private const val IS_NUMBER = "[ERROR] 금액은 숫자이여야 합니다."
    }
}