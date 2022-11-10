package lotto

import lotto.Constant.Companion.lottoSize
import lotto.Constant.Companion.printBuyMessage

fun main() {
    saveLotto()
    WinningNumber().inputWinningNumber()
}


fun saveLotto() {
    val lottoPrice = BuyAmount().inputAmount()
    val lottoWallet = mutableListOf<Lotto>()

    println("\n$lottoPrice$printBuyMessage")
    for (i in 0 until lottoPrice) {
        val makeLotto = Ticket().makeLotto()
        lottoWallet.add(Lotto(makeLotto))
        PrintMethod().printWallet(makeLotto)
    }
}