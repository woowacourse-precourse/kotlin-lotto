package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.InputValidation

class InputView {

    val inputValidation = InputValidation()

    fun getPurchasePrice(): Int {
        println(PURCHASE_PRICE_INPUT_MESSAGE)
        val input= Console.readLine()
        val purchasePrice = inputValidation.checkInputInteger(input)
        inputValidation.checkAmountMultipleOfThousand(purchasePrice)
        return purchasePrice
    }

    companion object {
        const val PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요."
    }
}