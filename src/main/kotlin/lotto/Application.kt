package lotto

import java.lang.IllegalArgumentException

const val MIN = 1
const val MAX = 45

fun main() {
    try {
        val purchase = Purchase(Purchase.inputPrice())
        Lotto.publish(purchase.count)
        Lotto.printCount()
        LottoWin.input()
        WinningStatistics.calculateWin(Lotto.lottoes)
        WinningStatistics.print(purchase.price)
    } catch (exception: IllegalArgumentException) {

    }
}
