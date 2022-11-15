package lotto.view

import lotto.domain.Rank

class Output {
    fun printTickets(tickets: List<String>) {
        println("${tickets.size}$TICKET_COUNT_MESSAGE")
        tickets.map { ticket -> println(ticket) }
    }

    fun printWinners(ranks: List<Rank>, totalRanks: List<Int>) {
        println(WINNER_MESSAGE_TITLE)
        for (index in totalRanks.indices) {
            println("${ranks[index].message} - ${totalRanks[index]}개")
        }
    }

    fun printYield(yieldPercentage: String) {
        println("총 수익률은 $yieldPercentage%입니다.")
    }

    companion object {
        const val TICKET_COUNT_MESSAGE = "개를 구매했습니다."
        const val WINNER_MESSAGE_TITLE = "당첨 통계\n" +
                "---"
    }
}