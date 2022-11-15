package lotto.domain

import kotlin.math.roundToInt

class YieldCalculator {

    fun getWinMoney(rank: List<Int>): Int {
        var winMoney = 0
        val money = arrayOf(2000000000, 30000000, 1500000, 50000, 5000)
        for (i in rank.indices) {
            winMoney += (rank[i] * money[i])
        }
        return winMoney
    }

    fun getYield(winMoney: Int, spentMoney: Int): Double {
        val yieldValue: Double = (winMoney.toDouble() / spentMoney.toDouble()) * 100
        return (yieldValue * 10).roundToInt() / 10.0
    }
}
