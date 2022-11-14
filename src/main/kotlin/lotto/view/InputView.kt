package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.exception.Validator

private enum class InputMessage(val message: String) {
    LOTTO_MONEY("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.")
}

object InputView {

    fun getLottoMoney(): Int {
        println(InputMessage.LOTTO_MONEY.message)
        val input = Console.readLine()
        println()
        return Validator.checkMoneyInput(input)
    }

}
