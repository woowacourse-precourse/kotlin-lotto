package lotto.domain

import camp.nextstep.edu.missionutils.Console

const val REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
const val REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

class WinningNumberGenerator {
    fun generate(): List<Int> {
        return getWinningNumbers() + getBonusNumber()
    }

    private fun getWinningNumbers(): List<Int> {
        println(REQUEST_WINNING_NUMBER_MESSAGE)
        val input = Console.readLine().split(", ")
        return input.map { it.toInt() }
    }

    private fun getBonusNumber(): Int {
        println(REQUEST_BONUS_NUMBER_MESSAGE)
        val input = Console.readLine()
        return input.toInt()
    }
}