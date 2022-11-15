package error

import error.ErrorMaking.Companion.makeError
import resource.*

object LottoError {
    fun checkLottoNumbers(numbers: List<Int>) {
        checkOutOfRange(numbers)
        checkDuplicate(numbers)
        checkNumOfLotto(numbers)
    }

    fun checkNumOfLotto(numbers: List<Int>) {
        if (numbers.size != Number_OF_LOTTO) {
            makeError(ErrorMaking.INCORRECT_NUMBER)
        }
    }

    fun checkOutOfRange(number: Int) {
        if (number !in RANGE_START..RANGE_END) {
            makeError(ErrorMaking.OUT_OF_RANGE)
        }
    }

    fun checkOutOfRange(numbers: List<Int>) {
        for (number in numbers) {
            checkOutOfRange(number)
        }
    }

    fun checkDuplicate(numbers: List<Int>) {
        val set = numbers.toSet()
        if (set.size != numbers.size) {
            makeError(ErrorMaking.NUMBER_DUPLICATED)
        }
    }

    fun checkDuplicate(numbers: List<Int>, number: Int) {
        if (numbers.contains(number)) {
            makeError(ErrorMaking.NUMBER_DUPLICATED)
        }
    }
}

object InputError {
    fun checkMoneyValid(value: String?) {
        checkInteger(value)
        checkNegative(value!!.toInt())
        checkMoneyZero(value.toInt())
        checkMoneyDivided(value.toInt())
    }

    fun checkIntegerValid(value: String?, winning: List<Int>) {
        checkInteger(value)
        LottoError.checkOutOfRange(value!!.toInt())
        LottoError.checkDuplicate(winning, value.toInt())
    }

    fun checkInteger(value: String?) {
        try {
            value!!.toInt()
        } catch (e: Exception) {
            makeError(ErrorMaking.NOT_INTEGER_VALUE)
        }
    }

    fun checkNegative(number: Int) {
        if (number < 0) {
            makeError(ErrorMaking.NEGATIVE_NUMBER)
        }
    }

    fun checkMoneyDivided(money: Int) {
        if (money % LOTTO_PRICE != 0) {
            makeError(ErrorMaking.MONEY_UNIT_INCORRECT)
        }
    }

    fun checkMoneyZero(money: Int) {
        if (money == 0) {
            makeError(ErrorMaking.MONEY_ZERO)
        }
    }

    fun checkWinningsFormat(value: String?) {
        try {
            value!!.split(SEPARATOR).forEach { n -> n.trim().toInt() }
        } catch (e: Exception) {
            makeError(ErrorMaking.NUMBER_FORMAT_INCORRECT)
        }
    }
}