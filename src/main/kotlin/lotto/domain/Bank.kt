package lotto.domain

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

}