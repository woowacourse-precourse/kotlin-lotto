package lotto.domain

import lotto.enums.ErrorMessages

data class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.joinToString("").all { it.isDigit() }) { ErrorMessages.DIGIT_EXCEPTION }
        require(numbers.size == 6) { ErrorMessages.SIZE_EXCEPTION }
        require(numbers.all { it in 1..45 }) { ErrorMessages.RANGE_EXCEPTION }
        require(numbers.distinct().count() == 6) { ErrorMessages.DISTINCT_EXCEPTION }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun compare(winningNumbers: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
        var (hit, bonus) = 0 to false
        for (number in numbers) {
            hit += compareHit(number, winningNumbers)
            bonus = compareBonus(number, bonusNumber)
        }
        return hit to bonus
    }

    private fun compareHit(number: Int, winningNumbers: Lotto): Int {
        if (winningNumbers.contains(number)) {
            return 1
        }
        return 0
    }

    private fun compareBonus(number: Int, bonusNumber: Int): Boolean {
        if (number == bonusNumber) {
            return true
        }
        return false
    }

    override fun toString(): String {
        var string = "["
        for (number in numbers) {
            when (number) {
                numbers.last() -> string += number
                else -> string += "$number, "
            }
        }
        return "$string]"
    }

    companion object {
        private const val PREFIX = "[ERROR]"
        private const val DIGIT_EXCEPTION = "숫자가 아닙니다."
        private const val SIZE_EXCEPTION = "갯수가 맞지 않습니다."
        private const val RANGE_EXCEPTION = "범위를 벗어났습니다."
        private const val DISTINCT_EXCEPTION = "중복이 있습니다."
    }
}
