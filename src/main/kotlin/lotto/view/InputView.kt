package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.InputValidation
import lotto.domain.Lotto

class InputView {

    val inputValidation = InputValidation()

    fun getPurchasePrice(): Int {
        println(PURCHASE_PRICE_INPUT_MESSAGE)
        val input = Console.readLine()
        val purchasePrice = inputValidation.checkInputInteger(input)
        inputValidation.checkAmountMultipleOfThousand(purchasePrice)
        return purchasePrice
    }

    fun getWinningLottoNumbers(): Lotto {
        println(WINNING_NUMBER_INPUT_MESSAGE)
        val input = Console.readLine()
        var splitedInput = inputValidation.checkInputSplitWithComma(input)
        val winningNumbers = splitedInput.map { lottoNumber ->
            inputValidation.checkInputInteger(lottoNumber)
        }
        return Lotto(winningNumbers)
    }

    companion object {
        const val PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요."
        const val WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
    }
}