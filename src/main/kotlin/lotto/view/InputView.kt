package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Constants.INPUT_BONUS_NUMBER_TEXT
import lotto.utils.Constants.INPUT_PURCHASE_PRIZE_TEXT
import lotto.utils.Constants.INPUT_WINNING_NUMBER_TEXT

object InputView {

    fun inputMoney(): String {
        println(INPUT_PURCHASE_PRIZE_TEXT)
        return Console.readLine()
    }

    fun inputWinningNum(): String {
        println(INPUT_WINNING_NUMBER_TEXT)
        return Console.readLine()
    }

    fun inputBonusNum(): String {
        println(INPUT_BONUS_NUMBER_TEXT)
        return Console.readLine()
    }

}