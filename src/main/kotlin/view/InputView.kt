package view

import camp.nextstep.edu.missionutils.Console
import domain.CreateLottoNumber
import kotlin.system.exitProcess

class InputView {

    private val ERROR_MESSAGE_BUY_TICKET = "[ERROR] 로또 구입 금액은 천원 단위 숫자로만 입력해야 합니다."
    private val REGULAR_CORRECT_MONEY = "^[0-9]+0{3,}$"

    private val ERROR_MESSAGE_WINNING_NUMBER = "[ERROR] 당첨 번호 규칙에 맞지 않습니다."
    private val ERROR_MESSAGE_BONUS_NUMBER = "[ERROR] 보너스 번호 규칙에 맞지 않습니다."

    // 구입할 금액 입력
    fun inputMoney(): Long {
        val money = readLine()!!
        try{
            if (money.matches(REGULAR_CORRECT_MONEY.toRegex()))
                return money.toLong()
        }catch (e: Exception){
            println("$ERROR_MESSAGE_BUY_TICKET 입력 값: $money")
            throw IllegalArgumentException("$ERROR_MESSAGE_BUY_TICKET 입력 값: $money")
        }
        println("$ERROR_MESSAGE_BUY_TICKET 입력 값: $money")
        throw IllegalArgumentException("$ERROR_MESSAGE_BUY_TICKET 입력 값: $money")
    }

    // 당첨 번호 입력
    fun inputWinningNumber(): List<Int>{
        val winningNumber = readLine()!!
        try {
            val sixWinningNumber =  winningNumber.split(",").map { it.toInt() }
            if (sixWinningNumber.toSet().size == 6 && sixWinningNumber.all { it in 1..45 }) {
                println(sixWinningNumber)
                return sixWinningNumber
            }
        }catch (e:Exception){
            throw IllegalArgumentException("$ERROR_MESSAGE_WINNING_NUMBER 입력 값: $winningNumber")
        }
        throw IllegalArgumentException("$ERROR_MESSAGE_WINNING_NUMBER 입력 값: $winningNumber")
    }

    fun inputBonusNumber(correctLotto: List<Int>): Int{
        val inputBonusNumber = readLine()!!
        try {
            val bonusNumber = inputBonusNumber.toInt()
            if (bonusNumber !in correctLotto && bonusNumber in 1..45) return bonusNumber
        }catch (e: Exception){
            throw IllegalArgumentException("$ERROR_MESSAGE_BONUS_NUMBER 입력 값: $inputBonusNumber")
        }
        throw IllegalArgumentException("$ERROR_MESSAGE_BONUS_NUMBER 입력 값: $inputBonusNumber")
    }

}