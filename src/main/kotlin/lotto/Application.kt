package lotto

import lotto.controller.LottoShop
import lotto.domain.ProfitCalculator
import lotto.domain.RandomNumberGenerator
import lotto.domain.Rank
import lotto.view.Input
import lotto.view.Output

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
