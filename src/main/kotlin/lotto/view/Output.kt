package lotto.view

import lotto.domain.Rank

class Output {
    fun printTickets(tickets: List<String>) {}

    fun printWinners(rank: List<Rank>, totalRanks: List<Int>) {}

    fun printYield(yield: Double) {}
}