package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Constants.INPUT_BONUS_NUMBER
import lotto.utils.Constants.INPUT_PURCHASING_AMOUNT
import lotto.utils.Constants.INPUT_WINNING_LOTTERY
import lotto.utils.Validator

object InputView {

    fun inputPurchasingAmount(): Long {
        println(INPUT_PURCHASING_AMOUNT)
        return Validator.checkNumber(Console.readLine())
    }

    fun inputWinningLottery(): String {
        println(INPUT_WINNING_LOTTERY)
        return Console.readLine()
    }

    fun inputBonusNumber(): String {
        println('\n'.plus(INPUT_BONUS_NUMBER))
        return Console.readLine()
    }
}
