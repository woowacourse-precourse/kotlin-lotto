package lotto.view

import lotto.domain.Rank

class Output {
    fun printTickets(tickets: List<String>) {
        println("${tickets.size}$TICKET_COUNT_MESSAGE")
        tickets.map { ticket -> println(ticket) }
    }

    fun printWinners(rank: List<Rank>, totalRanks: List<Int>) {}

    fun printYield(yield: Double) {}

    companion object {
        const val TICKET_COUNT_MESSAGE = "개를 구매했습니다."
    }
}