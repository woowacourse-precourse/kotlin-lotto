package lotto

import lotto.controller.LottoShop
import lotto.domain.LottoMachine
import lotto.domain.ProfitCalculator
import lotto.domain.RandomNumberGenerator
import lotto.domain.Rank
import lotto.view.Input
import lotto.view.Output
import java.lang.IllegalArgumentException

const val GENERATOR_START_INCLUSIVE = 1
const val GENERATOR_END_INCLUSIVE = 45
const val GENERATOR_HOW_MANY = 6
const val ERROR_HEADER = "[ERROR]"

fun main() {
    val input = Input()
    val output = Output()
    val generator = RandomNumberGenerator(GENERATOR_START_INCLUSIVE, GENERATOR_END_INCLUSIVE, GENERATOR_HOW_MANY)
    val lottoMachine = LottoMachine(generator)
    val ranks = Rank.values().toList()
    val profitCalculator = ProfitCalculator()
    val lottoShop = LottoShop(input, output, lottoMachine, ranks, profitCalculator)

    try {
        lottoShop.publish()
        lottoShop.announceWinners()
        lottoShop.announceYield()
    }catch (e: IllegalArgumentException) {
        println("$ERROR_HEADER ${e.message}")
    }
}
