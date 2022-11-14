package lotto.bank

import lotto.Lotto

interface Bank {
    val prizeGrades: MutableList<Int>
    var earningRate: Float

    fun calcPrizeGrade(receivedMainLottoNumbers: List<Int>, receivedBonusLottoNumber: Int, lotto: Lotto)

    fun calcWinningMainLottoNumbers(receivedMainLottoNumbers: List<Int>, lotto: Lotto): Int

    fun calcWinningBonusLottoNumber(receivedBonusLottoNumber: Int, lotto: Lotto): Boolean

    fun calcEarningRate(purchaseAmount: Int)

    fun calcTotalPrizeMoney(): Int
}
