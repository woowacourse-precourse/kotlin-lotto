package lotto

import util.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.NUMBER_OF_LOTTO.constant)
        require(numbers.distinct() == numbers)
    }

    fun compareWinningNumber(winningNumber: List<Int>): Int {
        var result = Constants.ZERO.constant
        winningNumber.forEach { n ->
            if (numbers.contains(n)) result++
        }
        return result
    }

    fun compareBonusNumber(bonusNumber: Int): Boolean {
        if (numbers.contains(bonusNumber)) return true
        return false
    }
}
