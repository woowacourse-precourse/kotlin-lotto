package lotto

object InputValidator {
    fun validateMoney(money: Int) = (money > 0) && (money % 1000 == 0)

    fun validateWinningNumber(winningNumber: List<String>): Boolean {
        var isValid = true

        when {
            winningNumber.size != SIZE_OF_LOTTO_NUMBERS -> isValid = false
            !winningNumber.joinToString("").isNumeric() -> isValid = false
            !winningNumber.isInRange() -> isValid = false
            winningNumber.hasOverLappedNumber() -> isValid = false
        }
        return isValid
    }

    fun validateBonusNumber(bonusNumber: String, winningNumber: List<Int>): Boolean {
        var isValid = true

        when {
            !bonusNumber.isNumeric() -> isValid = false
            !bonusNumber.isInRange() -> isValid = false
            winningNumber.contains(bonusNumber.toInt()) -> isValid = false
        }
        return isValid
    }

    private fun List<String>.hasOverLappedNumber(): Boolean {
        val existNumber = mutableSetOf<String>()

        this.forEach { number ->
            if (existNumber.contains(number)) {
                return true
            }
            existNumber.add(number)
        }
        return false
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

    private fun String.isInRange(): Boolean = this.toInt() in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER

}