package lotto.ui

import lotto.domain.LottoList
import lotto.enum.OutputString
import lotto.enum.StatisticsString

class OutputManager {
    fun printWinningStatistics(winningResult: List<Int>, earningsRate: Double) {
        StatisticsString.printStatics(winningResult, earningsRate)
    }

    fun printPurchaseNumber(number: Int) {목록
        OutputString.PURCHASE_NUMBER.print(number)
    }

    fun printUserLotto(userLotto: LottoList) {
        println("$userLotto")
    }
}