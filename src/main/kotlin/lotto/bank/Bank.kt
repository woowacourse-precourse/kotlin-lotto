package lotto.bank

import lotto.Lotto

interface Bank {

    fun calcPrizeGrade()

    fun calcWinningMainLottoNumbers(receivedMainLottoNumbers: List<Int>, lotto: Lotto): Int

    fun calcWinningBonusLottoNumber(receivedBonusLottoNumber: Int, lotto: Lotto): Boolean

    fun calcEarningRate(purchaseAmount: Int, prizeGrades: List<Int>)
}
