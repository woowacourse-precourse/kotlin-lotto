package lotto.views

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Constant

object InputView {
    fun inputMoney(): String {
        return Console.readLine()
    }

    fun inputWinningNumber(): MutableList<Int> {
        val winningNumbers = mutableListOf<Int>()
        val input: List<String> = Console.readLine().trim().split(',')
        for (index in Constant.START_INDEX until input.size) {
            winningNumbers.add(input[index].toInt())
        }
        return winningNumbers
    }

    fun inputBonusNumber(): String {
        return Console.readLine()
    }
}