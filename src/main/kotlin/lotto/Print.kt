package lotto

import lotto.Message.Companion.BUY_LOTTO_MESSAGE
import lotto.Message.Companion.DASH_MESSAGE
import lotto.Message.Companion.END_PROFITS_MESSAGE
import lotto.Message.Companion.FIVE_AND_BONUS_MATCH_MESSAGE
import lotto.Message.Companion.FIVE_MATCH_MESSAGE
import lotto.Message.Companion.FORMATTING
import lotto.Message.Companion.FOUR_MATCH_MESSAGE
import lotto.Message.Companion.FRONT_PROFITS_MESSAGE
import lotto.Message.Companion.INPUT_MONEY_MESSAGE
import lotto.Message.Companion.MATCH_END_MESSAGE
import lotto.Message.Companion.PUTIN_WINNING_NUMBER_MESSAGE
import lotto.Message.Companion.PUT_IN_BONUS_NUMBER_MESSAGE
import lotto.Message.Companion.SIX_MATCH_MESSAGE
import lotto.Message.Companion.STATISTIC_MESSAGE
import lotto.Message.Companion.THREE_MATCH_MESSAGE
import lotto.Units.Companion.GRADE_FOURTH
import lotto.Units.Companion.GRADE_FIRST
import lotto.Units.Companion.PERCENT
import lotto.Units.Companion.GRADE_THIRD
import lotto.Units.Companion.GRADE_SECOND

fun printInputMoney() = println(INPUT_MONEY_MESSAGE)

fun printButLotto(count: Int) {
    println("${count}${BUY_LOTTO_MESSAGE}")
}

fun printTickets(
    issuedLottery: MutableList<List<Int>>,
    lotteryCount: Int
) {
    println(issuedLottery[lotteryCount])
}

fun printPutinWinningNumber() {
    println(PUTIN_WINNING_NUMBER_MESSAGE)
}

fun printPutInBonusNumber() {
    println(PUT_IN_BONUS_NUMBER_MESSAGE)
}

fun printStatistics() {
    println(STATISTIC_MESSAGE)
    println(DASH_MESSAGE)
}

fun printRewards(winningNumber: List<Int>, bonusNumber: Int) {
    println(THREE_MATCH_MESSAGE + winningNumber[GRADE_FOURTH] + MATCH_END_MESSAGE )
    println(FOUR_MATCH_MESSAGE + winningNumber[GRADE_THIRD] + MATCH_END_MESSAGE )
    println(FIVE_MATCH_MESSAGE + winningNumber[GRADE_SECOND] + MATCH_END_MESSAGE )
    println(FIVE_AND_BONUS_MATCH_MESSAGE + bonusNumber + MATCH_END_MESSAGE)
    println(SIX_MATCH_MESSAGE + winningNumber[GRADE_FIRST] + MATCH_END_MESSAGE )
}

fun printProfit(prize: Int, sales: Int) {
    val profit = FORMATTING.format(prize.toDouble() / sales * PERCENT)
    println(FRONT_PROFITS_MESSAGE + profit + END_PROFITS_MESSAGE)
}

fun printNotNumberErrorMessage() {
    println(Message.NOT_INT_MESSAGE)
    throw NoSuchElementException()
}