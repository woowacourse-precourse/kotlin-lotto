package lotto

import lotto.Constant.Companion.lottoSize
import lotto.Constant.Companion.printBuyMessage

fun main() {
    addLotto()
    WinningNumber().inputWinningNumber()
}


fun toIntArray(lottoWallet: IntArray, lotto: MutableList<Int>) {
    for (i in 0 until lottoSize) {
        lottoWallet[i] = lotto[i]
    }
}

fun addLotto() {
    val lottoPrice = BuyAmount().inputAmount()
    val lottoWallet = Array(lottoPrice) { IntArray(lottoSize) }

    println("\n$lottoPrice$printBuyMessage")
    for (i in 0 until lottoPrice) {
        toIntArray(lottoWallet[i], Ticket().makeLotto())
        PrintMethod().printWallet(lottoWallet[i])
    }
}