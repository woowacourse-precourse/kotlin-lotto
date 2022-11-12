package lotto.domain

import lotto.util.Constant
import lotto.util.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        validateSize()
        validateDuplication()
    }

    private fun validateSize() = require(numbers.size == Constant.LOTTO_COUNT) {
        ErrorMessage.sizeError(Constant.LOTTO_NUMBER)
    }

    private fun validateDuplication() = require(numbers.distinct().size == Constant.LOTTO_COUNT) {
        ErrorMessage.duplicateError(Constant.LOTTO_NUMBER)
    }

    fun getLottoNumber() = numbers.sorted()

    fun confirmWinning(winningNumber: List<Int>, bonusNumber: Int): Int {
        val match = winningNumber.filter {
            numbers.contains(it)
        }.size
        if (numbers.contains(bonusNumber) && match == Constant.FIVE_MATCH) {
            return Constant.SECOND
        }
        return getRank(match)
    }

    private fun getRank(match: Int) = when (match) {
        Constant.THREE_MATCH -> Constant.FIFTH

        Constant.FOUR_MATCH -> Constant.FOURTH

        Constant.FIVE_MATCH -> Constant.THIRD

        Constant.SIX_MATCH -> Constant.FIRST

        else -> Constant.NOTHING
    }
}
