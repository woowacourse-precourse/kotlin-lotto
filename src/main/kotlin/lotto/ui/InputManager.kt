package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.enum.Configuration
import lotto.enum.ErrorString
import lotto.enum.InputString

class InputManager {
    private fun String.isNumberString() = this.all { it.isDigit() }

    private fun checkWinningNumbers(input: List<String>){
        when{
            input.any{ !it.isNumberString() || it.toInt() !in 1..45 } ->
                throw IllegalArgumentException(ErrorString.OUT_OF_BOUND.string)
            input.size != 6 ->
                throw IllegalArgumentException(ErrorString.LOTTO_SIZE.string)
        }
    }

    private fun checkPurchaseAmount(input: String) {
        when {
            !input.isNumberString() ->
                throw IllegalArgumentException(ErrorString.NOT_DIGIT.string)
            input.toInt() % 1000 != 0 ->
                throw IllegalArgumentException(ErrorString.PURCHASE_AMOUNT_UNIT.string)
        }
    }

    private fun checkBonusNumber(input: String){
        when{
            !input.isNumberString() || input.toInt() !in 1..45 ->
                throw IllegalArgumentException(ErrorString.OUT_OF_BOUND.string)
        }
    }

    fun askPurchaseAmount(): Int {
        InputString.ASK_PURCHASE_AMOUNT.print()
        val input = Console.readLine()
        checkPurchaseAmount(input)
        return input.toInt()
    }

    private fun askWinningNumbers(): List<Int> {
        InputString.ASK_WINNING_NUMBER.print()
        val input = Console.readLine().split(',')
        checkWinningNumbers(input)
        return input.map { it.toInt() }
    }

    private fun askBonusNumber(): Int{
        InputString.ASK_BONUS_NUMBER.print()
        val input = Console.readLine()
        checkBonusNumber(input)
        return input.toInt()
    }

    private fun checkDrawnNumber(winningNumber: List<Int>, bonusNumber: Int){
        val uniqueNumbers = winningNumber.toMutableSet()
        uniqueNumbers.add(bonusNumber)
        if(uniqueNumbers.size != Configuration.LOTTO_SIZE.number + 1)
            throw IllegalArgumentException(ErrorString.DUPLICATED_DRAWN_NUMBERS.string)
    }

    fun askDrawnNumbers(): Pair<List<Int>, Int>{
        val winningNumber = askWinningNumbers()
        println()
        val bonusNumber = askBonusNumber()
        checkDrawnNumber(winningNumber, bonusNumber)
        return winningNumber to bonusNumber
    }
}