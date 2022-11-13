package lotto.Model

import lotto.ValidateInput

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        // 예외 확인
        val validator = ValidateInput()

        for (i in numbers)
            validator.validateRange(i)
        validator.validateDuplication(numbers)

    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun compareWithWinningNumber(winningNum: Lotto): Int {
        var count = 0
        for (i in winningNum.getNumbers()) {
            if (numbers.contains(i))
                count++
        }
        return count
    }

    fun calculateWinningResult(winningNumber: Lotto, bonusNumber: Int): Pair<Rank, Int> {
        val count = compareWithWinningNumber(winningNumber)
        val rank = determineRank(count, bonusNumber)
        val sumPrizeMoney = rank.prizeMoney

        return Pair(rank, sumPrizeMoney)
    }

    fun determineRank(count: Int, bonusNumber: Int): Rank {
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

}
