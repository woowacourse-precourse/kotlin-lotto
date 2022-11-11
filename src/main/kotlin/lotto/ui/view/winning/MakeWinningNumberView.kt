package lotto.ui.view.winning

import camp.nextstep.edu.missionutils.Console

class MakeWinningNumberView {
    fun enterWinningNumber(): String {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        return Console.readLine()
    }

    fun enterBonusNumber(): String {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        return Console.readLine()
    }

    companion object {
        private const val INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}