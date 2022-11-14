package lotto.ui

import lotto.enum.StatisticsString

class OutputManager {
    fun printWinningStatistics(winningList: List<Int>, earningsRate:Int){
        StatisticsString.printStatics(winningList, earningsRate)
    }
}