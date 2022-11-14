package lotto.domain

import lotto.resources.*

class WinningLotto(private val winningNumbers: Lotto, private val bonusNumber: Int) {
    init {
        require(bonusNumber !in winningNumbers.toList()) { ERROR_INPUT_VALUE_NO_DUPLICATES }
        require(bonusNumber in LOTTO_START_NUMBER..LOTTO_END_NUMBER) {
            ERROR_INPUT_VALUE_ONE_OR_FORTY_FIVE_ONLY
        }
    }

    private fun getResult(guessNumbers: List<Int>): Pair<Int, Boolean> {
        return Pair(
            winningNumbers.toList().countSameNumbers(guessNumbers),
            bonusNumber in guessNumbers
        )
    }

    fun getPrize(guessNumbers: List<Int>): Int {
        val (countSame, bonus) = getResult(guessNumbers)
        return LottoRank.of(countSame, bonus).prize
    }

    fun getRank(guessNumbers: List<Int>): Int {
        val (countSame, bonus) = getResult(guessNumbers)
        return LottoRank.of(countSame, bonus).ordinal + 1
    }

    private fun List<Int>.countSameNumbers(guess: List<Int>) = this.filter { it in guess }.size
}
