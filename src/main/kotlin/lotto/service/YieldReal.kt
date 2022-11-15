package lotto.service

import java.text.DecimalFormat

interface Yield {
    fun plusMoney(buyLottoMoney: String, checkWinningScore: MutableList<Int>): Double
}
class YieldReal : Yield {
    private val decimalFormat = DecimalFormat("#.#")
    enum class RankingReward(val value: Int) {
        THREE(5000),
        FOUR(50000),
        FIVE(1500000),
        SIX(2000000000),
        FIVEBONUS(30000000)
    }

    override fun plusMoney(buyLottoMoney: String, checkWinningScore: MutableList<Int>): Double {
        val buyLottoMoney = buyLottoMoney.toInt() * 1000
        var getMoney = 0
        getMoney += checkWinningScore[0] * RankingReward.THREE.value
        getMoney += checkWinningScore[1] * RankingReward.FOUR.value
        getMoney += checkWinningScore[2] * RankingReward.FIVE.value
        getMoney += checkWinningScore[3] * RankingReward.FIVEBONUS.value
        getMoney += checkWinningScore[4] * RankingReward.SIX.value
        val yieldUser: Double = getMoney.toDouble() / buyLottoMoney.toDouble() * 100
        val yield = decimalFormat.format(yieldUser)
        println("총 수익률은 $`yield`%입니다.")
        return yieldUser
    }
}