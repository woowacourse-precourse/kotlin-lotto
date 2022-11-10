package lotto

import lotto.Constant.Companion.bonusDupleErrorMessage
import lotto.Constant.Companion.lottoSize
import lotto.Constant.Companion.printBuyMessage

fun main() {
    val lottery = saveLotto()
    val winningNumber = WinningNumber().inputWinningNumber()
    val bonusNumber = BonusNumber().inputBonusNumber()

    dupleException(winningNumber, bonusNumber)

    val rank = sumRanking(lottery, winningNumber, bonusNumber)
    PrintMethod().printRanking(rank)
}

fun sumRanking(lottery: MutableList<Lotto>, winningNumber: List<Int>, bonusNumber: Int): MutableList<Int> {
    val ranking = mutableListOf<Int>(0, 0, 0, 0, 0)

    for (lotto in lottery) {
        when (lotto.findWinning(lotto.getNumbers(), winningNumber, bonusNumber)) {
            Reward.FIRST -> ranking[0] += 1
            Reward.SECOND -> ranking[1] += 1
            Reward.THIRD -> ranking[2] += 1
            Reward.FOURTH -> ranking[3] += 1
            Reward.FIFTH -> ranking[4] += 1
        }
    }
    return ranking

}


fun saveLotto(): MutableList<Lotto> {
    val lottoPrice = BuyAmount().inputAmount()
    val lottoWallet = mutableListOf<Lotto>()

    PrintMethod().printBuyAmount(lottoPrice)
    for (i in 0 until lottoPrice) {
        val makeLotto = Ticket().makeLotto()
        val lotto = Lotto(makeLotto)

        lottoWallet.add(lotto)
        PrintMethod().printWallet(makeLotto)
    }
    return lottoWallet
}

fun dupleException(winningNumber: List<Int>, bonusNumber: Int) {
    if (winningNumber.contains(bonusNumber)) {
        println(bonusDupleErrorMessage)
        throw IllegalArgumentException(bonusDupleErrorMessage)
    }
}