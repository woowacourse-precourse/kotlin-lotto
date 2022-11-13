package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Constants.ERROR_MESSAGE_BODY_NUMBER_SHOULD_BE_DIVIDED_BY_UNIT
import lotto.util.Constants.ERROR_MESSAGE_HEADER
import lotto.util.Constants.INPUT_BONUS_NUMBER
import lotto.util.Constants.INPUT_PURCHASE_AMOUNT
import lotto.util.Constants.INPUT_WINNING_NUMBER
import lotto.util.Validator.isCorrectFormatInputBonusNumber
import lotto.util.Validator.isCorrectFormatInputWinningNumber
import lotto.util.Validator.isDividedByUnit
import lotto.util.toListSplitByComma

class InputView {

    fun inputPurchaseAmount() {
        println(INPUT_PURCHASE_AMOUNT)
        val inputPurchaseAmount: String = Console.readLine()
        require(isDividedByUnit(inputPurchaseAmount.toInt())) {
            ERROR_MESSAGE_HEADER + ERROR_MESSAGE_BODY_NUMBER_SHOULD_BE_DIVIDED_BY_UNIT
        }
    }

    fun inputWinningNumber() {
        println(INPUT_WINNING_NUMBER)
        val inputWinningNumber: String = Console.readLine()
        val inputWinningNumbers = inputWinningNumber.toListSplitByComma()
        // TODO(당첨 번호 저장하는 로직 추가)
        println(inputWinningNumber)
        require(isCorrectFormatInputWinningNumber(inputWinningNumbers)) {
            ERROR_MESSAGE_HEADER
        }
    }

    fun inputBonusNumber() {
        println(INPUT_BONUS_NUMBER)
        val inputBonusNumber: String = Console.readLine()
        // TODO(보너스 번호 저장하는 로직 추가)
        require(isCorrectFormatInputBonusNumber(inputBonusNumber)) {
            ERROR_MESSAGE_HEADER
        }
    }
}