package lotto

import lotto.Constant.Companion.lottoCost
import lotto.Constant.Companion.printBuyMessage

class PrintMethod {
    fun printBuyAmount(amount: Int) {
        println("${amount % lottoCost}" + printBuyMessage)
    }
}