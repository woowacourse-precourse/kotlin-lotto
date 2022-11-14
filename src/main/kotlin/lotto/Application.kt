package lotto

import lotto.controller.LottoShop
import lotto.domain.ProfitCalculator
import lotto.domain.RandomNumberGenerator
import lotto.domain.Rank
import lotto.view.Input
import lotto.view.Output
import java.lang.IllegalArgumentException

const val ERROR_HEADER = "[ERROR]"

fun main() {
    val input = Input()
    val output = Output()
    val generator = RandomNumberGenerator()
    val ranks = Rank.values().toList()
    val profitCalculator = ProfitCalculator()
    val lottoShop = LottoShop(input, output, generator, ranks, profitCalculator)

    try {
        lottoShop.publish()
        lottoShop.announceWinners()
        lottoShop.announceYield()
    }catch (e: IllegalArgumentException) {
        println("$ERROR_HEADER ${e.message}")
    }
}
