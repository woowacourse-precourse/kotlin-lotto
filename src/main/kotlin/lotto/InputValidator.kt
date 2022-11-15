package lotto

object InputValidator {
    fun validateMoney(money: String): Error {
        var isOccurredError = Error.NO_ERROR

        when {
            !money.isNumeric() -> isOccurredError = Error.ERROR_NUMERIC
            money.toInt() % LOTTO_PRICE != 0 -> isOccurredError = Error.ERROR_INPUT_MONEY
        }
        return isOccurredError
    }

    fun validateWinningNumber(winningNumber: List<String>): Error {
        var isOccurredError = Error.NO_ERROR

        when {
            winningNumber.size != SIZE_OF_LOTTO_NUMBERS -> isOccurredError = Error.ERROR_OVER_SIZE
            !winningNumber.joinToString("").isNumeric() -> isOccurredError = Error.ERROR_NUMERIC
            !winningNumber.isInRange() -> isOccurredError = Error.ERROR_RANGE
            winningNumber.hasOverLappedNumber() -> isOccurredError = Error.ERROR_OVERLAPPED
        }
        return isOccurredError
    }

    fun validateBonusNumber(bonusNumber: String, winningNumber: List<Int>): Error {
        var isOccurredError = Error.NO_ERROR

        when {
            !bonusNumber.isNumeric() -> isOccurredError = Error.ERROR_NUMERIC
            !bonusNumber.isInRange() -> isOccurredError = Error.ERROR_RANGE
            winningNumber.contains(bonusNumber.toInt()) -> isOccurredError = Error.ERROR_OVERLAPPED
        }
        return isOccurredError
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
    }

    private fun List<String>.isInRange(): Boolean {
        this.forEach { number ->
            if (number.toInt() > MAXIMUM_LOTTO_NUMBER || number.toInt() < MINIMUM_LOTTO_NUMBER) {
                return false
            }
        }
        return true
    }

    private fun String.isInRange() = this.toInt() in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER
}