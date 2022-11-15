package lotto

object Exceptions {
    fun isInvalidMoney(money: String) {
        isDigit(money)

        if (money.toInt() < 1000)
            throw IllegalArgumentException("입력 값이 로또의 금액보다 낮습니다.")

        if (money.toInt() % 1000 != 0)
            throw IllegalArgumentException("입력 값이 1000원으로 나눠 떨어지지 않습니다.")
    }


    fun isInvalidWinningNumber(winningNumber: List<String>) {
        winningNumber.forEach {
            isDigit(it)
        }

        checkDuplicateNumber(winningNumber)
        checkRange(winningNumber)
    }

    fun isInvalidBonusNumber(winningNumber: List<String>, bonusNumber: String) {
        isDigit(bonusNumber)

        winningNumber.forEach {
            if (it == bonusNumber)
                throw IllegalArgumentException("당첨 번호와 보너스 번호는 중복되지 않습니다.")
        }
    }

    private fun isDigit(number: String) {
        val regex = Regex("\\D")
        if (regex.matches(number))
            throw IllegalArgumentException("입력 값이 숫자가 아닙니다.")
    }

    private fun checkRange(numbers: List<String>) {
        numbers.forEach {
            if (it.toInt() in 1..45)
                throw IllegalArgumentException("로또 번호의 범위 안에 들지 않는 값이 있습니다.")
        }
    }

    private fun checkDuplicateNumber(numbers: List<String>) {
        if (numbers.toSet().size != 6)
            throw IllegalArgumentException("같은 로또 번호가 입력되었습니다.")
    }
}