package lotto.presentation

import lotto.domain.LottoRanks
import lotto.domain.Money
import lotto.utils.LOTTO_STATIC_MESSAGE
import lotto.utils.TOTAL_YIELD_RATE_MESSAGE

object LottoStaticsView {
    fun printLottoStatics(lottoRanks: LottoRanks, earned: Money, investment: Money) {
        printEnter()
        println(LOTTO_STATIC_MESSAGE)
        printMatchingLotto(lottoRanks)
        printYieldRate(earned, investment)
    }

    private fun printMatchingLotto(lottoRanks: LottoRanks) {
        lottoRanks.entries.forEach { entry ->
            val (lottoRank, count) = entry.toPair()
            println(lottoRank.message.format(count))
        }
    }

    private fun printYieldRate(earned: Money, investment: Money) {
        print(TOTAL_YIELD_RATE_MESSAGE.format(earned.calculateYieldRate(investment)))
    }

    private fun printEnter() = println()
}