package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.enum.ErrorString
import lotto.enum.InputString
import lotto.enum.StatisticsString

class UIManager(private val inputManager: InputManager, private val outputManager: OutputManager) {
    fun askPurchaseAmount(): Int {
        return inputManager.askPurchaseAmount()
    }

    fun askWinningNumber(): List<Int> {
        return inputManager.askWinningNumber()
    }

    fun askBonusNumber(): Int{
        return inputManager.askBonusNumber()
    }

    fun printWinningStatistics(winningList: List<Int>, earningsRate:Int){
        outputManager.printWinningStatistics(winningList, earningsRate)
    }
}