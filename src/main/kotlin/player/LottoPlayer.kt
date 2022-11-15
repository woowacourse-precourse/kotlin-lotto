package player

import enterprise.LOTTO_MAX_GRADE
import enterprise.LOTTO_MIN_GRADE
import enterprise.LottoEnterprise
import enterprise.SameLottoResult
import enterprise.lottoPrize
import lotto.Lotto
import market.LottoMarket
import util.printLottoEarningsRate
import util.printLottoGradeCountToMessage
import winlotto.WinLotto

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
        val lottoGrades = getSameLottiesResult(winLotto, lotties).map { it.parseSameResultToGrade() }
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
            lottoPrize[grade] * count
        }.sum()
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