package lotto.ui.view.winning

import camp.nextstep.edu.missionutils.Console
import lotto.ui.view.View

class MakeWinningNumberView: View() {
    fun enterWinningNumber(): String {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        return Console.readLine().trim()
    }

    fun enterBonusNumber(): String {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        return Console.readLine().trim()
    }

    companion object {
        private const val INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
    }
}