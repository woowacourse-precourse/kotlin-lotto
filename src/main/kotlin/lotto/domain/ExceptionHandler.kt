package lotto.domain

object ExceptionHandler {
    private const val PURCHASING_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 구입금액이 올바르지 않습니다."
    private const val WINNING_NUMBERS_EXCEPTION_MESSAGE = "[ERROR] 당첨번호가 올바르지 않습니다."

    /**
     * 구입 금액 예외 처리
     *
     * 1. 1000으로 나누어 떨어지지 않을 때
     *
     * 2. 숫자가 아닐 때
     * */
    fun checkInputPurchasingAmount(inputPurchasingAmount: String) {
        if (!hasRemainderOfPurchasingAmount(inputPurchasingAmount)
            or !isNumberOfPurchasingAmount(inputPurchasingAmount)
        ) {
            throw IllegalArgumentException(PURCHASING_AMOUNT_EXCEPTION_MESSAGE)
        }
    }

    private fun hasRemainderOfPurchasingAmount(inputPurchasingAmount: String): Boolean {
        if (inputPurchasingAmount.toInt() % 1000 > 0) {
            return false
        }
        return true
    }

    private fun isNumberOfPurchasingAmount(inputPurchasingAmount: String): Boolean {
        if (!inputPurchasingAmount.all { it.isDigit() }) {
            return false
        }
        return true
    }

    /**
     * 당첨번호 예외 처리
     *
     * 1. split 시 숫자가 아닐 때
     *
     * 2. split 했을 때 요소 수가 6개가 아닐 때
     *
     * 3. 로또 범위 내 숫자가 아닐 때
     *
     * 4. 중복이 있을 때
     * */
    fun checkInputWinningNumbers(inputWinningNumbers: String) {
        val winningNumbers = inputWinningNumbers.split(",")
        if (!isNumberOfWinningNumbers(winningNumbers)
            or !hasElementOfWinningNumbers(winningNumbers)
            or !isCorrectRangeOfWinningNumbers(winningNumbers)
            or !isUniqueOfWinningNumbers(winningNumbers)
        ) {
            throw IllegalArgumentException(WINNING_NUMBERS_EXCEPTION_MESSAGE)
        }
    }

    private fun isNumberOfWinningNumbers(winningNumbers: List<String>): Boolean {
        if (!winningNumbers
                .joinToString("")
                .all { it.isDigit() }
        ) {
            return false
        }
        return true
    }

    private fun hasElementOfWinningNumbers(winningNumbers: List<String>): Boolean {
        if (winningNumbers.size != 6) {
            return false
        }
        return true
    }

    private fun isCorrectRangeOfWinningNumbers(winningNumbers: List<String>): Boolean {
        for (number in winningNumbers) {
            if (number.toInt() !in 1..45) {
                return false
            }
        }
        return true
    }

    private fun isUniqueOfWinningNumbers(winningNumbers: List<String>): Boolean {
        if (winningNumbers.size
            != winningNumbers
                .distinct()
                .count()
        ) {
            return false
        }
        return true
    }
}