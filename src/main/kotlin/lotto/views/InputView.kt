package lotto.views

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Constant

object InputView {
    fun inputMoney(): Int {
        return Console.readLine().toInt()
    }

    fun inputWinningNumber(): MutableList<Int> {
        val winningNumbers = mutableListOf<Int>()
        val input: List<String> = Console.readLine().trim().split(',')
        for (index in Constant.START_INDEX until input.size) {
            winningNumbers.add(input[index].toInt())
        }
        return winningNumbers
    }

    fun inputBonusNumber(): Int {
        return Console.readLine().toInt()
    }
}