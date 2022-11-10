package lotto

import lotto.Constant.Companion.lottoSize
import lotto.Constant.Companion.printBuyMessage

fun main() {
    val lottery = saveLotto()
    val winningNumber = WinningNumber().inputWinningNumber()
    println(winningNumber)
    val bonusNumber = BonusNumber().inputBonusNumber()
    println(lottery)

}


fun saveLotto(): MutableList<Lotto> {
    val lottoPrice = BuyAmount().inputAmount()
    val lottoWallet = mutableListOf<Lotto>()

    PrintMethod().printBuyAmount(lottoPrice)
    for (i in 0 until lottoPrice) {
        val makeLotto = Ticket().makeLotto()

        lottoWallet.add(Lotto(makeLotto))
        PrintMethod().printWallet(makeLotto)
    }
    return lottoWallet
}

fun exception(winningNumber: List<String>, bonusNumber: Int) {

}