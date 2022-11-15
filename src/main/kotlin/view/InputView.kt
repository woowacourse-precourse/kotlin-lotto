package view

import camp.nextstep.edu.missionutils.Console
import domain.CreateLottoNumber

class InputView {

    private val TICKET_PRICES = 1000
    private val ERROR_MESSAGE_BUY_TICKET = "[ERROR] 로또 구입 금액은 천원 단위 숫자로만 입력해야 합니다."
    private val REGULAR_CORRECT_MONEY = "^[0-9]+0{3,}$"

    private val ERROR_MESSAGE_WINNING_NUMBER = "[ERROR] 당첨 번호 규칙에 맞지 않습니다."
    private val ERROR_MESSAGE_BONUS_NUMBER = "[ERROR] 보너스 번호 규칙에 맞지 않습니다."
    private val ERROR_MESSAGE_BONUS_NUMBER_OVERLAP = "[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.."

    // 구입할 금액 입력
    fun inputMoney(): Long {
        val money = Console.readLine()
        try{
            if (money.matches(REGULAR_CORRECT_MONEY.toRegex()))
                println(money)
                return money.toLong()/TICKET_PRICES
        }catch (e: Exception){
            throw IllegalArgumentException("$ERROR_MESSAGE_BUY_TICKET 입력 값: $money")
        }
        throw IllegalArgumentException("$ERROR_MESSAGE_BUY_TICKET 입력 값: $money")
    }

    // 당첨 번호 입력
    fun inputWinningNumber(): List<Int>{
        val winningNumber = Console.readLine()
        try {
            val sixWinningNumber =  winningNumber.split(",").map { it.toInt() }

            if (CreateLottoNumber().isCorrectCreateLotto(sixWinningNumber))
                return sixWinningNumber
            else throw IllegalArgumentException("$ERROR_MESSAGE_WINNING_NUMBER 입력 값: $winningNumber")

        }catch (e:Exception){
            throw IllegalArgumentException("$ERROR_MESSAGE_WINNING_NUMBER 입력 값: $winningNumber")
        }
    }

    fun inputBonusNumber(correctLotto: List<Int>): Int{
        val inputBonusNumber = Console.readLine()
        try {
            val bonusNumber = inputBonusNumber.toInt()
            if (bonusNumber !in correctLotto && bonusNumber in 1..45) return bonusNumber
        }catch (e: Exception){
            throw IllegalArgumentException("$ERROR_MESSAGE_BONUS_NUMBER 입력 값: $inputBonusNumber")
        }
        throw IllegalArgumentException("$ERROR_MESSAGE_BONUS_NUMBER 입력 값: $inputBonusNumber")
    }

}