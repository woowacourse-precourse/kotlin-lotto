package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.controller.LottoController.Companion.ERROR_MESSAGE

object InputView {

    private const val INPUT_PURCHASE_PRIZE_TEXT = "구매금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBER_TEXT = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER_TEXT = "보너스 번호를 입력해 주세요."

    fun inputMoney(): Int {
        println(INPUT_PURCHASE_PRIZE_TEXT)
        val userInput = Console.readLine()!!
        validatePurchaseNum(userInput)
        return userInput.toInt()
    }

    fun inputWinningNum(): List<Int> {
        println(INPUT_WINNING_NUMBER_TEXT)
        val userInput = Console.readLine()!!
        validateWinningNum(userInput)
        return userInput.map { it.code - '0'.code }
    }

    fun inputBonusNum(): Int {
        println(INPUT_BONUS_NUMBER_TEXT)
        val userInput = Console.readLine()!!
        validateBonusNum(userInput)
        return userInput.toInt()
    }


    private fun validatePurchaseNum(userInput: String) {
        require(userInput.isNotBlank() && userInput.all { Character.isDigit(it) }) {
            "$ERROR_MESSAGE 로또 구입 금액은 숫자로 입력해 주세요."
        }
        require(userInput.toInt() % 1000 == 0) {
            "$ERROR_MESSAGE 1,000원 단위로 입력해 주세요."
        }
    }

    private fun validateWinningNum(userInput: String) {
        val splitedNum = userInput.split(',')
        val numRegex = Regex("[^0-9]")
        require(userInput.isNotBlank() && splitedNum.joinToString("").all { it.isDigit() }) {
            "$ERROR_MESSAGE 로또 번호는 숫자로 입력해 주세요."
        }
        require(splitedNum.all { it.toInt() in 1..45 }) {
            "$ERROR_MESSAGE 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        }
    }

    private fun validateBonusNum(userInput: String) {
        require(userInput.isNotBlank() &&
                userInput.all { Character.isDigit(it) }) {
            "$ERROR_MESSAGE 보너스 번호는 숫자로 입력해 주세요."
        }
    }

}