package lotto

import constant.LOTTO_MAX_GRADE
import constant.LOTTO_MIN_GRADE
import enterprise.LottoEnterprise
import market.LottoMarket
import util.printLottoEarningsRate
import util.printLottoGradeCountToMessage
import winlotto.WinLotto

data class SameLottoResult(
    val lottoSameCount: Int,
    val isBonusSame: Boolean,
) {
    fun parseResultToGrade(): Int = when (this.lottoSameCount) {
        3 -> 5
        4 -> 4
        5 -> {
            if (this.isBonusSame) 2
            else 3
        }
        6 -> 1
        else -> 0
    }
}

class LottoPlayer(
    private val lottoEnterprise: LottoEnterprise,
    private val lottoMarket: LottoMarket,
) {
    private lateinit var lotties: List<Lotto>
    private var payMoney: Int = 0

    fun buyLotties() {
        payMoney = lottoMarket.payMoney()
        lotties = lottoMarket.sellLotties(payMoney)
    }

    fun matchLotties() {
        val winLotto = lottoEnterprise.getWinLotto()
        val lottoGrades = getSameLottiesResult(winLotto, lotties).map { it.parseResultToGrade() }
        val gradeCounts = getGradeCounts(lottoGrades)
        showLottoResults(gradeCounts)
    }

    private fun showLottoResults(gradeCounts: IntArray) {
        showLottoResultGrade(gradeCounts)
        showLottoEarningRate(gradeCounts)
    }

    private fun showLottoEarningRate(gradeCounts: IntArray) {
        val lottoPrizeSum = getLottoPrizeSum(gradeCounts)
        printLottoEarningsRate(lottoPrizeSum, payMoney)
    }

    private fun showLottoResultGrade(gradeCounts: IntArray) {
        for (grade in LOTTO_MAX_GRADE downTo LOTTO_MIN_GRADE) {
            printLottoGradeCountToMessage(grade, gradeCounts[grade])
        }
    }

    private fun getLottoPrizeSum(gradeCounts: IntArray): Long {
        return gradeCounts.mapIndexed { grade, count ->
            parseGradeToPrize(grade, count)
        }.sum()
    }

    private fun parseGradeToPrize(grade: Int, count: Int): Long {
        val prize = when (grade) {
            5 -> 5_000
            4 -> 50_000
            3 -> 1_500_000
            2 -> 30_000_000
            1 -> 2_000_000_000
            else -> 0
        }
        return prize * count.toLong()

    }

    private fun getSameLottiesResult(
        winLotto: WinLotto,
        lotties: List<Lotto>,
    ): List<SameLottoResult> {
        return List(lotties.size) {
            lotties[it].matchLotto(winLotto)
        }
    }

    private fun getGradeCounts(lottoGrades: List<Int>): IntArray {
        val gradeCounts = IntArray(LOTTO_MAX_GRADE + 1)
        lottoGrades.forEach { grade ->
            gradeCounts[grade]++
        }
        gradeCounts[0] = 0
        return gradeCounts
    }

}