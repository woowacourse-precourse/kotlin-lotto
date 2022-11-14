package lotto.bank

import lotto.Lotto
import lotto.bank.Grade.Companion.SECOND_AND_THIRD_WINNING_MAIN_LOTTO_NUMBERS_COUNT
import kotlin.properties.Delegates

class BankImpl : Bank {
    override val prizeGrades = mutableListOf<Int>(0, 0, 0, 0, 0)
    override var earningRate by Delegates.notNull<Float>()
    override fun calcPrizeGrade(receivedMainLottoNumbers: List<Int>, receivedBonusLottoNumber: Int, lotto: Lotto) {
        val winningMainLottoNumbersCount = calcWinningMainLottoNumbers(receivedMainLottoNumbers, lotto)
        val winningBonusLottoNumberState = calcWinningBonusLottoNumber(receivedBonusLottoNumber, lotto)

        when (winningMainLottoNumbersCount) {
            Grade.FIRST.winningMainLottoNumbersCount -> prizeGrades[Grade.FIRST.prizeGradesIndex] += 1
            SECOND_AND_THIRD_WINNING_MAIN_LOTTO_NUMBERS_COUNT -> {
                if (winningBonusLottoNumberState) {
                    prizeGrades[Grade.SECOND.prizeGradesIndex] += 1
                    return
                }
                prizeGrades[Grade.THIRD.prizeGradesIndex] += 1
            }
            Grade.FOURTH.winningMainLottoNumbersCount -> prizeGrades[Grade.FOURTH.prizeGradesIndex] += 1
            Grade.FIFTH.winningMainLottoNumbersCount -> prizeGrades[Grade.FIFTH.prizeGradesIndex] += 1
        }
    }

    override fun calcWinningMainLottoNumbers(receivedMainLottoNumbers: List<Int>, lotto: Lotto): Int =
        receivedMainLottoNumbers.intersect(lotto.getLottoNumbers().toSet()).size

    override fun calcWinningBonusLottoNumber(receivedBonusLottoNumber: Int, lotto: Lotto): Boolean =
        receivedBonusLottoNumber in lotto.getLottoNumbers()

    override fun calcEarningRate(purchaseAmount: Int, prizeGrades: List<Int>) {
        earningRate = calcTotalPrizeMoney(prizeGrades).toFloat() / purchaseAmount * 100
    }

    override fun calcTotalPrizeMoney(prizeGrades: List<Int>): Int {
        var totalPrizeMoney = 0
        for ((prizeGrade, prizeGradeCount) in prizeGrades.withIndex()) {
            when (prizeGrade + 1) {
                Grade.FIRST.gradeNumber -> totalPrizeMoney += prizeGradeCount * Grade.FIRST.prizeMoney
                Grade.SECOND.gradeNumber -> totalPrizeMoney += prizeGradeCount * Grade.SECOND.prizeMoney
                Grade.THIRD.gradeNumber -> totalPrizeMoney += prizeGradeCount * Grade.THIRD.prizeMoney
                Grade.FOURTH.gradeNumber -> totalPrizeMoney += prizeGradeCount * Grade.FOURTH.prizeMoney
                Grade.FIFTH.gradeNumber -> totalPrizeMoney += prizeGradeCount * Grade.FIFTH.prizeMoney
            }
        }
        return totalPrizeMoney
    }
}
