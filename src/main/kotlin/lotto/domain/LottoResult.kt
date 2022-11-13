package lotto.domain

import kotlin.math.round

class LottoResult() {
    private val ranks = listOf("FIFTH", "FORTH", "THIRD", "SECOND", "FIRST")

    fun getResult(winningNumbers: WinningNumber, playerTickets: List<Lotto>): Map<String, Int> {
        var result = mutableMapOf("FIRST" to 0, "SECOND" to 0, "THIRD" to 0, "FORTH" to 0, "FIFTH" to 0, "NOTHING" to 0)

        for (ticket in playerTickets) {
            result[ticket.check(winningNumbers)] = result[ticket.check(winningNumbers)]!! + 1
        }

        return result
    }

    fun printResult(results: Map<String, Int>, playerCost: Int) {
        println("당첨 통계\n---")
        for (rank in ranks) {
            if (rank == "SECOND") {
                println("${Reward.getSameCount(rank)}개 일치, 보너스 볼 일치 (${Reward.getPrizeMoney(rank)}원) - ${results[rank]}개")
                continue
            }
            println("${Reward.getSameCount(rank)}개 일치 (${Reward.getPrizeMoney(rank)}원) - ${results[rank]}개")
        }
        println("총 수익률은 " + getProfit(results, playerCost) + "%입니다.")
    }

    private fun getProfit(results: Map<String, Int>, playerCost: Int): String {
        var sum = 0.0F
        var prize: String
        for (rank in ranks) {
            prize = Reward.getPrizeMoney(rank).replace(",", "")
            sum += (prize.toInt() * results[rank]!!)
        }

        return (sum / playerCost * 100).toString()
    }

}