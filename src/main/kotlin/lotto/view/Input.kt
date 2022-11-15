package lotto.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun getMoney(): String {
        println(INPUT_MONEY_GUIDE)
        return get()
    }

    fun getBonusNumber(): String {
        startOfNewLine()
        println(INPUT_BONUS_NUMBER_GUIDE)
        return get()
    }

    fun getWinningNumbers(): String {
        startOfNewLine()
        println(INPUT_WINNING_NUMBERS_GUIDE)
        return get()
    }

    private fun startOfNewLine() {
        println()
    }

    private fun get(): String {
        val userInput = Console.readLine()
        println(userInput)
        return userInput
    }

    companion object {
        const val INPUT_MONEY_GUIDE = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBERS_GUIDE = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요."
    }
}