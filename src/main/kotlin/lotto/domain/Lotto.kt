package lotto.domain

import lotto.util.Constant
import lotto.util.ErrorMessage
import lotto.util.Rank

class Lotto(private val numbers: List<Int>) {
    init {
        validateSize()
        validateDuplication()
    }

    private fun validateSize() = require(numbers.size == Constant.LOTTO_COUNT) {
        ErrorMessage.size(Constant.LOTTO_NUMBER)
    }

    private fun validateDuplication() = require(numbers.distinct().size == Constant.LOTTO_COUNT) {
        ErrorMessage.duplicate(Constant.LOTTO_NUMBER)
    }

    fun getLottoNumber() = numbers.sorted()

    fun checkWinning(winningNumber: List<Int>, bonusNumber: Int): Int {
        val match = winningNumber.filter { it in numbers }.size
        if (match == Constant.FIVE_MATCH && bonusNumber in numbers) {
            return Rank.SECOND.rank
        }
        return getRank(match)
    }

    private fun getRank(match: Int) = when (match) {
        Constant.THREE_MATCH -> Rank.FIFTH.rank

        Constant.FOUR_MATCH -> Rank.FOURTH.rank

        Constant.FIVE_MATCH -> Rank.THIRD.rank

        Constant.SIX_MATCH -> Rank.FIRST.rank

        else -> Constant.NOTHING
    }
}
