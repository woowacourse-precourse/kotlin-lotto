package lotto

object Exceptions {
    fun isInvalidMoney(money: String) {
        isDigit(money)

        if (money.toInt() % 1000 != 0)
            throw IllegalArgumentException("입력 값이 1000원으로 나눠 떨어지지 않습니다.")

        if (money.toInt() < 1000)
            throw IllegalArgumentException("입력 값이 로또의 금액보다 낮습니다.")
    }

    private fun isDigit(number: String) {
        val regexOnlyNumber = Regex("\\d")
        if (!regexOnlyNumber.matches(number))
            throw IllegalArgumentException("입력 값이 숫자가 아닙니다.")
    }
}