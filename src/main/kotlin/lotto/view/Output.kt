package lotto.view

import lotto.domain.Rank

class Output {
    fun guideInputMoney() {
        println(INPUT_MONEY_GUIDE)
    }

    fun printTickets(tickets: List<String>) {}

    fun printWinners(rank: List<Rank>, totalRanks: List<Int>) {}

    fun printYield(yield: Double) {}

    companion object {
        const val INPUT_MONEY_GUIDE = "구입금액을 입력해 주세요."
    }
}