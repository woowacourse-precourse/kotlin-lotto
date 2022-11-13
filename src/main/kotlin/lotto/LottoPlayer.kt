package lotto

import lotto.constant.LOTTO_MAX_GRADE
import lotto.constant.LOTTO_MIN_GRADE
import lotto.util.printLottoGradeCountToMessage
import lotto.util.showError

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
    lateinit var lotties: List<Lotto>
    fun buyLotties() {
        lotties = lottoMarket.sellLotties()
    }

    fun matchLotties() {
        try {
            val winLotto = lottoEnterprise.getWinLotto()
            val lottoGrades = getSameLottiesResult(winLotto, lotties).map { it.parseResultToGrade() }
            val gradeCounts = getGradeCounts(lottoGrades)
            showLottoResults(gradeCounts)
        } catch (e: Exception) {
            showError(e)
            throw IllegalArgumentException()
        }
    }

    private fun showLottoResults(gradeCounts: IntArray) {
        for (grade in LOTTO_MAX_GRADE downTo LOTTO_MIN_GRADE) {
            printLottoGradeCountToMessage(grade, gradeCounts[grade])
        }
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