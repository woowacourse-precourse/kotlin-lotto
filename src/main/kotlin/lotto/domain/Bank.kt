package lotto.domain

import lotto.Win
import java.util.*

class Bank(private val lottos: List<List<Int>>) {
    val winStatistic: MutableMap<Win, Int> = EnumMap(Win::class.java)

    init {
        for (place in Win.values()) {
            winStatistic[place] = 0
        }
    }

    fun writeWinStatistic(winNumbers: List<Int>, bonusNumber: Int) {
        for (lotto in lottos) {
            val myLotto = Lotto(lotto)
            val place = myLotto.checkMyLotto(winNumbers, bonusNumber)
            this.winStatistic[place] = this.winStatistic[place]!! + 1
        }
    }

    fun getTotalIncome(): Long {
        var totalIncome = 0L
        for (place in winStatistic.keys) {
            totalIncome += Win.getIncome(place) * winStatistic[place]!!
        }
        return totalIncome
    }

    fun getRateOfReturn(totalIncome: Long, purchasingAmount: Long): Double {
        return totalIncome.toDouble() / purchasingAmount * 100
    }
}