package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.lang.StringBuilder
import kotlin.math.round

class Lottos(amount: Int) {
    private val lottos: MutableList<Lotto> = mutableListOf()

    init {
        produceLotto(amount)
    }

    private fun produceLotto(amount: Int) {
        for (i in 0 until amount) {
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottos.add(lotto)
        }
    }

    fun calculateWinRanks(winNumber: List<Int>, bonusNumber: Int): Map<LottoRank, Int> {
        val rankMap = mutableMapOf<LottoRank, Int>()

        for (i in lottos) {
            val calculatedRank = i.calculateWinRank(winNumber, bonusNumber)
            rankMap[calculatedRank] = (rankMap[calculatedRank] ?: 0) + 1
        }

        return rankMap
    }

    fun calculateYield(winRanks: Map<LottoRank, Int>, lottoMoney: Int): Float {
        var winMoney = 0f

        for ((k, v) in winRanks) {
            winMoney += k.value * v
        }

        return round((winMoney / (lottoMoney * 1000) * 1000)) / 10
    }

    override fun toString(): String {
        val formattedLottos = StringBuilder()

        for (i in lottos) {
            formattedLottos.append(i.toString() + "\n")
        }

        return formattedLottos.toString()
    }
}