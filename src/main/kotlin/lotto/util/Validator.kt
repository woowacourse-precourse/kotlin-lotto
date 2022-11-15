package lotto.util

class Validator {

    fun checkMoneyInput(input : String?) {
        checkInputNullValidation(input)
        checkInputEmptyValidation(input!!)
        checkStringToIntValidation(input!!)
        checkMoneyValueValidation(input)
    }

    fun checkWinnigNumberInput(input : String?) {
        checkInputNullValidation(input)
        checkInputEmptyValidation(input!!)
        checkWinnigNumberToIntValidation(input!!)
    }

    fun checkBonusInput(input : String?) {
        checkInputNullValidation(input)
        checkInputEmptyValidation(input!!)
        checkStringToIntValidation(input!!)
        checkBonusNumberRangeValidation(input!!)
    }

    fun checkBonusNumberRangeValidation(input : String) {
        require(input.toInt() >= LOTTO_MIN_NUM && input.toInt() <= LOTTO_MAX_NUM) { BONUS_RANGE_ERROR_MSG }
    }

    fun checkWinnigNumberToIntValidation(input : String) {
        try {
            val nums = input.split(",")
            nums.map { it.toInt() }
        } catch(e : NumberFormatException) {
            throw IllegalArgumentException(INPUT_VALUE_ERROR_MSG)
        }
    }

    fun checkInputEmptyValidation(input : String) {
        require(input != "") { INPUT_EMPTY_ERROR_MSG }
    }

    fun checkInputNullValidation(input: String?) {
        require(input != null) { INPUT_NULL_ERROR_MSG }
    }
    fun checkStringToIntValidation(input : String) {
        try {
            input.toInt()
        } catch (e : NumberFormatException) {
            throw IllegalArgumentException(INPUT_VALUE_ERROR_MSG)
        }
    }
    fun checkMoneyValueValidation(input : String) {
        require(input.toInt() % LOTTO_PRICE == 0) { MONEY_VALUE_ERROR_MSG }
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_MIN_NUM = 1
        const val LOTTO_MAX_NUM = 45

        const val INPUT_NULL_ERROR_MSG = "[ERROR] 값이 입력되지 않았습니다."
        const val INPUT_EMPTY_ERROR_MSG = "[ERROR] 값이 입력되지 않았습니다."
        const val INPUT_VALUE_ERROR_MSG = "[ERROR] 값이 숫자로만 이루어져야합니다."
        const val MONEY_VALUE_ERROR_MSG = "[ERROR] 돈은 1000으로 나누어떨어지는 값이어야 합니다."
        const val BONUS_RANGE_ERROR_MSG = "[ERROR] 보너스는 1에서 45사이의 숫자여야 합니다."
    }
}