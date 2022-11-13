package lotto

import lotto.domain.ProfitCalculator
import lotto.domain.RandomNumberGenerator
import lotto.domain.Rank

fun main() {
    val input = Input()
    val output = Output()
    val generator = RandomNumberGenerator()
    val ranks = Rank.values().toList()
    val profitCalculator = ProfitCalculator()
    val lottoShop = LottoShop(input, output, generator, ranks, profitCalculator)

    lottoShop.publish()
    lottoShop.announceWinners()
    lottoShop.announceYield()
}
