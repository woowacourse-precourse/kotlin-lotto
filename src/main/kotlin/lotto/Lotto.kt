package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import utils.Constants
import utils.Constants.ERROR_MESSAGE_NOT_1000WON
import utils.Constants.ERROR_MESSAGE_OUT_OF_RANGE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(!isReduplicateNumber())
        require(!isNumberOverRange())
    }

    private fun isReduplicateNumber(): Boolean {
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] == numbers[i + 1])
                return true
        }
        return false
    }

    private fun isNumberOverRange(): Boolean {
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

