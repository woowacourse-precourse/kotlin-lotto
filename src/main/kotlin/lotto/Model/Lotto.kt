package lotto.Model

import lotto.ValidateInput

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            ValidateInput().validateLottoLength()
        }
        for (number in numbers)
            ValidateInput().validateRange(number)
        ValidateInput().validateDuplication(numbers)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun calculateWinningResult(winningNumber: Lotto, bonusNumber: Int): Rank {
        val containCount = compareWithWinningNumber(winningNumber)
        return determineRank(containCount, bonusNumber)
    }

    private fun compareWithWinningNumber(winningNum: Lotto): Int {
        var count = 0
        for (i in winningNum.getNumbers())
            if (numbers.contains(i))
                count++

        return count
    }

    private fun determineRank(containCount: Int, bonusNumber: Int): Rank {
        when (containCount) {
            6 -> return Rank.First
            5 -> {
                if (numbers.contains(bonusNumber))
                    return Rank.Second
                return Rank.Third
            }

            4 -> return Rank.Fourth
            3 -> return Rank.Fifth
            else -> return Rank.None
        }
    }
}
