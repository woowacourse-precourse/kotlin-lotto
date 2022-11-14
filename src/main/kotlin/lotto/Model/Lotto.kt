package lotto.Model

import lotto.ValidateInput
import lotto.View.OutputView
import lotto.constants.ERROR_DUPLICATION

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { validateLengthAndDuplication(numbers) }
        for (i in numbers)
            ValidateInput().validateRange(i)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun calculateWinningResult(winningNumber: Lotto, bonusNumber: Int): Rank {
        val count = compareWithWinningNumber(winningNumber)
        return determineRank(count, bonusNumber)
    }

    private fun compareWithWinningNumber(winningNum: Lotto): Int {
        var count = 0
        for (i in winningNum.getNumbers())
            if (numbers.contains(i))
                count++

        return count
    }

    private fun determineRank(count: Int, bonusNumber: Int): Rank {
        when (count) {
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

    private fun validateLengthAndDuplication(winningNumbers: List<Int>) {
        if (winningNumbers.distinct().size != 6) {
            OutputView().printErrorMessage(ERROR_DUPLICATION)
            throw IllegalArgumentException()
        }
    }
}
