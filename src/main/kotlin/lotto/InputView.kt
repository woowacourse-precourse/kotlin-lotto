package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.NullPointerException
import java.lang.NumberFormatException

class InputView {

    val validator = Validator()


    fun getInputMoney(): Int {
        return inputMoney().toInt()
    }

    fun getInputWinningNumber(): Lotto {
        val winninglottos = inputWinningLotto().split(",")
        return Lotto(winninglottos.map { it.toInt() })
    }

    fun getInputBonus() : Int {
        return inputBonus().toInt()
    }

    private fun inputBonus(): String {
        println(INPUT_BONUS_MSG)
        return checkInputBonus(Console.readLine())
    }

    private fun checkInputBonus(input: String?): String {
        validator.checkBonusInput(input)
        return input!!
    }

    fun inputWinningLotto(): String {
        println(INPUT_WINNING_LOTTO_MSG)
        return checkInputWinningLotto(Console.readLine())
    }

    private fun checkInputWinningLotto(input: String?): String {
        validator.checkWinnigNumberInput(input)
        return input!!
    }

    fun inputMoney(): String {
        println(INPUT_MONEY_MSG)
        return checkInputMoney(Console.readLine())
    }

    fun checkInputMoney(input: String?): String {

        validator.checkMoneyInput(input)
        return input!!

    }

    companion object {
        const val INPUT_MONEY_MSG = "구입 금액을 입력해 주세요."
        const val INPUT_WINNING_LOTTO_MSG = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_MSG = "보너스 번호를 입력해 주세요."
    }
}