package lotto

import lotto.Message.Companion.BUY_LOTTO_MESSAGE
import lotto.Message.Companion.INPUT_MONEY_MESSAGE

fun printButLottoMessage(count: Int) = println("${count}${BUY_LOTTO_MESSAGE}")
fun printTickets(issuedLottery: MutableList<List<Int>>, lotteryCount: Int) = println(issuedLottery[lotteryCount])
fun printInputMoneyMessage() = println(INPUT_MONEY_MESSAGE)
