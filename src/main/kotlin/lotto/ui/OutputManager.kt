package lotto.ui

import lotto.domain.LottoList
import lotto.enum.OutputString
import lotto.enum.StatisticsString

class OutputManager {
    fun printWinningStatistics(winningList: List<Int>, earningsRate: Double) {
        StatisticsString.printStatics(winningList, earningsRate)
    }

    fun printPurchaseNumber(number: Int) {
        OutputString.PURCHASE_NUMBER.print(number)
    }

    fun printUserLotto(userLotto: LottoList) {
        println("$userLotto")
    }
}