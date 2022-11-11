package lotto.domain

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.Exceptions

const val REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
const val REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

class WinningNumber {
    fun generate(): Pair<List<Int>, Int> {
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        return Pair(winningNumbers, bonusNumber)
    }

    private fun getWinningNumbers(): List<Int> {
        println(REQUEST_WINNING_NUMBER_MESSAGE)
        val input = readLine().split(", ")
        Exceptions().validateWinningNumbers(input)
        return input.map{ it.toInt() }
    }

    private fun getBonusNumber(numbers: List<Int>): Int {
        println(REQUEST_BONUS_NUMBER_MESSAGE)
        val input = readLine()
        Exceptions().validateBonusNumber(numbers, input)
        return input.toInt()
    }
}