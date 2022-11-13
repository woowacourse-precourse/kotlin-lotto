package lotto.domain

import kotlin.math.round

class LottoResult {
    fun getResult(): List<Int> {
        return listOf(1, 2,3 )
    }

    fun printResult(results: List<Int>) {
        println("당첨 통계\\n---")
        println(Reward.FIFTH.same + "개 일치 (" + Reward.FIFTH.reward + "원) - " + results[0] + "개")
        println(Reward.FORTH.same + "개 일치 (" + Reward.FORTH.reward + "원) - " + results[1] + "개")
        println(Reward.THIRD.same + "개 일치 (" + Reward.THIRD.reward + "원) - " + results[2] + "개")
        println(Reward.SECOND.same + "개 일치, 보너스 볼 일치 (" + Reward.SECOND.reward + "원) - " + results[3] + "개")
        println(Reward.FIRST.same + "개 일치 (" + Reward.FIRST.reward + "원) - " + results[4] + "개")
        println("총 수익률은 " + getProfit(results) +"%입니다.")
    }

    fun getProfit(results: List<Int>): Float {
        var sum = 0.0F
        var ticketCount = 0
        var index = 0

        if (results[index] != 0) {
            sum += (Reward.FIFTH.reward.toFloat() * results[index])
            ticketCount += results[index]
        }

        return round(sum / ticketCount * 100) / 100
    }

}