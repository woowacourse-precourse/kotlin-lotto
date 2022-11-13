package lotto.view

import lotto.domain.Lotto
import lotto.resources.*

fun printNumberOfTickets(ticket: Int) {
    println(OUTPUT_BOUGHT_TICKETS.format(ticket))
}

fun printNumbersOfLottos(lottos: List<Lotto>) {
    lottos.forEach {
        println(it.toList())
    }
}

fun printWinningNumbers(winningNumbers: List<Int>) {
    println(winningNumbers.joinToString(","))
}

fun printBonusNumber(bonus: Int) {
    println(bonus)
}

fun printPrizeResult(rankResult: List<Int>) {
    println(OUTPUT_WINNING_STATS)
    println(OUTPUT_FIFTH_PLACE.format(rankResult[4]))
    println(OUTPUT_FOURTH_PLACE.format(rankResult[3]))
    println(OUTPUT_THIRD_PLACE.format(rankResult[2]))
    println(OUTPUT_SECOND_PLACE.format(rankResult[1]))
    println(OUTPUT_FIRST_PLACE.format(rankResult[0]))
}

fun printRateOfReturn(rateOfReturn: Float) {
    println(OUTPUT_RATE_OF_RETURN.format(rateOfReturn))
}
