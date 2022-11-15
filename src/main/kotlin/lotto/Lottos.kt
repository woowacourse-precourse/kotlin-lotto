package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.lang.StringBuilder
import kotlin.math.round

class Lottos() {
    private var lottos: MutableList<Lotto> = mutableListOf()

    constructor(amount: Int) : this() {
        produceLotto(amount)
        require(lottos.size == amount) { "로또는 $amount 개 만큼 생성되어야 합니다." }
    }

    constructor(lottos: MutableList<Lotto>) : this() {
        this.lottos = lottos
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

    fun calculateYield(winRanks: Map<LottoRank, Int>, lottoAmount: Int): Float {
        var winMoney = 0f

        for ((k, v) in winRanks) {
            winMoney += k.value * v
        }

        val yieldRatio = (winMoney / (lottoAmount * 1000)) * 100
        return round(yieldRatio * 100) / 100
    }

    override fun toString(): String {
        val formattedLottos = StringBuilder()

        for (i in lottos) {
            formattedLottos.append(i.toString() + "\n")
        }

        return formattedLottos.toString()
    }
}