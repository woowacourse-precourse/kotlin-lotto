package lotto.bank

import lotto.Lotto
import kotlin.properties.Delegates

class BankImpl : Bank {
    var prizeGrades = listOf<Int>()
    var earningRate by Delegates.notNull<Float>()
    override fun calcPrizeGrade() {
        TODO("Not yet implemented")
    }

    override fun calcWinningMainLottoNumbers(receivedMainLottoNumbers: List<Int>, lotto: Lotto): Int =
        receivedMainLottoNumbers.intersect(lotto.getLottoNumbers().toSet()).size

    override fun calcWinningBonusLottoNumber(receivedBonusLottoNumber: Int, lotto: Lotto): Boolean =
        receivedBonusLottoNumber in lotto.getLottoNumbers()

    override fun calcEarningRate(purchaseAmount: Int, prizeGrades: List<Int>) {
        TODO("Not yet implemented")
    }
}
