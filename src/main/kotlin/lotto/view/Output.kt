package lotto.view

import lotto.domain.Rank
import java.text.DecimalFormat

class Output {
    fun printTickets(tickets: List<String>) {
        println("${tickets.size}$TICKET_COUNT_MESSAGE")
        tickets.map { ticket -> println(ticket) }
    }

    fun printWinners(ranks: List<Rank>, totalRanks: List<Int>) {
        val decimalFormat = DecimalFormat("#,###")
        println(WINNER_MESSAGE_TITLE)
        for (index in totalRanks.indices) {
            val rankMessage = ranks[index].message
            val rankPrize = decimalFormat.format(ranks[index].prize)
            val winners = totalRanks[index]
            println("$rankMessage (${rankPrize}원) - ${winners}개")
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