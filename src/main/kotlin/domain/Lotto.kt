package domain

import error.LottoError

class Lotto(private val numbers: List<Int>) {
    init {
        LottoError.checkLottoNumbers(numbers)
    }

    fun print() {
        println(numbers.toString())
    }

    fun getWinningRank(winningNumbers: List<Int>, bonusNumber: Int): Int {
        var countMatching = 0

        for (number in numbers) {
            if (winningNumbers.contains(number)) {
                countMatching++
            }
        }

        return when (countMatching) {
            Winning.FIFTH.countMatching -> Winning.FIFTH.ordinal
            Winning.FOURTH.countMatching -> Winning.FOURTH.ordinal
            Winning.THIRD.countMatching -> {
                if (numbers.contains(bonusNumber)) { Winning.SECOND.ordinal }
                else { Winning.THIRD.ordinal }
            }
            Winning.FIRST.countMatching -> Winning.FIRST.ordinal
            else -> -1
        }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}
