package lotto

class InputVerifier {
    var isBetween1And45 = true

    fun validateAmountOfPurchase(amountOfPurchase: Int) {
        if (amountOfPurchase % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.")
        }
    }

    fun validateWinningNumber(winningNumber: String) {
        val winningNumberList = winningNumber.split(",").toList().map { it.toInt() }

        if (!validateRange(winningNumberList)) {
            throw IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        if (validateDuplicated(winningNumberList)) {
            throw IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 존재하지 않아야 합니다.")
        }
        if (validateCount(winningNumberList)) {
            throw IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.")
        }
    }

    fun validateBonusNumber(bonusNumber: Int) {
        validateElementRange(bonusNumber)
        if (!isBetween1And45) {
            throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    private fun validateElementRange(number: Int) {
        if (number < 1 || number > 45) {
            isBetween1And45 = false
        }
    }

    private fun validateRange(winningNumberList: List<Int>): Boolean {
        for (i in winningNumberList.indices) {
            validateElementRange(winningNumberList[i])
        }
        return isBetween1And45
    }

    private fun validateDuplicated(winningNumberList: List<Int>): Boolean {
        return winningNumberList.size != winningNumberList.distinct().count()
    }

    private fun validateCount(winningNumberList: List<Int>): Boolean {
        return winningNumberList.size != 6
    }
}