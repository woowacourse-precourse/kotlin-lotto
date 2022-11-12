package lotto

import utils.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { Constants.ERROR_OVER_COUNT_MESSAGE }
        require(!isReduplicateNumber()) { Constants.ERROR_REDUPLICATED_NUMBER_MESSAGE }
        require(!isNumberOutOfRange()) { Constants.ERROR_OUT_OF_RANGE_MESSAGE }
    }

    private fun isReduplicateNumber(): Boolean {
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] == numbers[i + 1])
                return true
        }
        return false
    }

    private fun isNumberOutOfRange(): Boolean {
        for(number in numbers) {
            if(number < 1 || number > 45)
                return true
        }
        return false
    }

    fun getLotto(): List<Int> {
        return this.numbers
    }
}

