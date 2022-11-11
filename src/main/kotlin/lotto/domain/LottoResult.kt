package lotto.domain

import kotlin.math.round

enum class Reward(val same: String, val reward: String) {
    FIRST("6", "2,000,000,000"),
    SECOND("5","30,000,000"),
    THIRD("5", "1,500,000"),
    FORTH("4", "50,000"),
    FIFTH("3", "5,000"),
}
class LottoResult {
    fun getResult(): List<Int> {

    }

    fun printResult(results: List<Int>) {
        println("당첨 통계\\n---")
        println(Reward.FIFTH.same + "개 일치 (" + Reward.FIFTH.reward + "원) - " + results[0] + "개")
        println(Reward.FORTH.same + "개 일치 (" + Reward.FORTH.reward + "원) - " + results[1] + "개")
        println(Reward.THIRD.same + "개 일치 (" + Reward.THIRD.reward + "원) - " + results[2] + "개")
        println(Reward.SECOND.same + "개 일치, 보너스 볼 일치 (" + Reward.SECOND.reward + "원) - " + results[3] + "개")
        println(Reward.FIRST.same + "개 일치 (" + Reward.FIRST.reward + "원) - " + results[4] + "개")
        println("총 수익률은 " + getYield(results) +"%입니다.")
    }

    fun getYield(results: List<Int>): Float {
        var sum = 0.0F
        var ticketCount = 0
        var index = 0
        val yieldValue: Float

        if (results[index] != 0) {
            sum += (Reward.FIFTH.reward.toFloat() * results[index])
            ticketCount += results[index]
        }

        yieldValue = round(sum/ticketCount*100)/100
        return yieldValue
    }

}