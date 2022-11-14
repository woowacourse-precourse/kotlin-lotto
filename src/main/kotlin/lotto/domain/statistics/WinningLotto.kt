package lotto.domain.statistics

import lotto.domain.lotto.Lotto
import lotto.domain.prize.LottoPrize

class WinningLotto(private val lottoNumbers: List<Lotto>, private val bonusNumber: Int) {
    fun countWinningLotto(otherNumbers: List<Int>): Map<LottoPrize, Int> {
        val lottoPrizes = lottoNumbers
            .map { lotto -> winLotto(lotto, otherNumbers) }
            .filter { lottoPrize -> lottoPrize != LottoPrize.NO_WINNING_AMOUNT }
            .groupingBy { lottoPrize -> lottoPrize }
            .eachCount()
        return lottoPrizes.mapValues { it.value }
    }

    private fun winLotto(lotto: Lotto, otherNumbers: List<Int>): LottoPrize {
        val matchedCount = matchLottoNumber(lotto, otherNumbers)
        val isMatching = isMatchingBonusNumber(lotto)
        return LottoPrize.lottoValueOf(matchedCount, isMatching)
    }

    private fun matchLottoNumber(lotto: Lotto, otherNumbers: List<Int>): Int =
        lotto.getMachingLottoNumberCount(otherNumbers)

    private fun isMatchingBonusNumber(lotto: Lotto): Boolean =
        lotto.isMachingBonusNumber(bonusNumber)

}