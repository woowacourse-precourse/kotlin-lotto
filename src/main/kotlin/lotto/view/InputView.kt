package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoData.bonusNumber
import lotto.model.LottoData.publishedLottoNumber
import lotto.model.LottoData.winningNumbers
import lotto.util.Constants.ERROR_MESSAGE_BODY_INPUT_SHOULD_NOT_CONTAIN_CHARACTER
import lotto.util.Constants.ERROR_MESSAGE_BODY_NUMBER_SHOULD_BE_DIVIDED_BY_UNIT
import lotto.util.Constants.ERROR_MESSAGE_HEADER
import lotto.util.Constants.INPUT_BONUS_NUMBER
import lotto.util.Constants.INPUT_PURCHASE_AMOUNT
import lotto.util.Constants.INPUT_WINNING_NUMBER
import lotto.util.Constants.LOTTO_UNIT_NUMBER
import lotto.util.Validator.isCorrectFormatInputBonusNumber
import lotto.util.Validator.isCorrectFormatInputWinningNumber
import lotto.util.Validator.isDividedByUnit
import lotto.util.Validator.isNotContainsCharacter
import lotto.util.toListSplitByComma
import java.lang.IllegalArgumentException

class InputView {

    fun inputPurchaseAmount() {
        println(INPUT_PURCHASE_AMOUNT)
        val inputPurchaseAmount: String = Console.readLine()
        try {
            require(isNotContainsCharacter(inputPurchaseAmount)) {
                println(ERROR_MESSAGE_HEADER + ERROR_MESSAGE_BODY_INPUT_SHOULD_NOT_CONTAIN_CHARACTER)
            }
            require(isDividedByUnit(inputPurchaseAmount.toInt())) {
                println(ERROR_MESSAGE_HEADER + ERROR_MESSAGE_BODY_NUMBER_SHOULD_BE_DIVIDED_BY_UNIT)
            }
            publishedLottoNumber = inputPurchaseAmount.toInt() / LOTTO_UNIT_NUMBER
        } catch (ex: IllegalArgumentException) {
            inputPurchaseAmount()
        }
    }

    fun inputWinningNumber() {
        println(INPUT_WINNING_NUMBER)
        val inputWinningNumber: String = Console.readLine()
        val inputWinningNumbers = inputWinningNumber.toListSplitByComma()
        println(inputWinningNumber)
        require(isCorrectFormatInputWinningNumber(inputWinningNumbers)) {
            println(ERROR_MESSAGE_HEADER)
        }
        winningNumbers = inputWinningNumbers.map { it.toInt() }
    }

    fun inputBonusNumber() {
        println(INPUT_BONUS_NUMBER)
        val inputBonusNumber: String = Console.readLine()
        require(isCorrectFormatInputBonusNumber(inputBonusNumber)) {
            ERROR_MESSAGE_HEADER
        }
        bonusNumber = inputBonusNumber.toInt()
    }
}