package view

import camp.nextstep.edu.missionutils.Console
import lotto.LottoMessage
import java.util.*
import java.util.regex.Pattern
import java.util.stream.Collectors
import kotlin.NoSuchElementException

object InputView {
    private const val WINNING_NUMBER_PATTERN = "^([1-9]{1,2}[,][\\s]?){5}[1-9]{1,2}$"
    private const val NUMBER_PATTERN = "^[0-9]*$"
    private val COMPILED_WINNING_NUMBER_PATTERN = Pattern.compile(WINNING_NUMBER_PATTERN)
    private val COMPILED_NUMBER_PATTERN = Pattern.compile(NUMBER_PATTERN)
    private const val WINNING_NUMBER_REST = ","

    fun inputValidMoney(): Int {
        val money = inputMoney()
        return money.toInt()
    }

    private fun inputMoney(): String {
        println(LottoMessage.PURCHASE_AMOUNT)
        val money = Console.readLine()
        validateMoney(money)
        return money
    }

    private fun validateMoney(money: String) {
        if (!COMPILED_NUMBER_PATTERN.matcher(money).matches()) {
            throw NoSuchElementException("[ERROR] 숫자만 입력해주세요.")
        }
        val number = money.toInt()
        println()
        require(number in 1000..2147483000) { LottoMessage.MINIMUM_PURCHASE_AMOUNT_ERROR }
        require(number % 1000 == 0) { LottoMessage.NUMBER_DIVISIBLE_BY_1000 }
    }

    fun inputValidLottoNumber(): List<Int> {
        val numbers = inputLottoNumber()
        return Arrays.stream(
            numbers.split(WINNING_NUMBER_REST.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        )
            .map { number -> number.trim { it <= ' ' } }
            .map(Integer::parseInt)
            .collect(Collectors.toList())
    }

    private fun inputLottoNumber(): String {
        println(LottoMessage.WINNING_NUMBERS)
        val winningNumber = Console.readLine()
        validateWinningNumber(winningNumber)
        println()
        return winningNumber
    }

    private fun validateWinningNumber(winningNumber: String) {
        require(
            COMPILED_WINNING_NUMBER_PATTERN.matcher(winningNumber).matches()
        ) { LottoMessage.WINNING_NUMBER_FORMAT_ERROR }
        winningNumber.split(",").forEach { require(it.toInt() in 1..45) { LottoMessage.LOTTERY_RANGE_ERROR } }
    }

    fun inputValidBonusNumber(): Int {
        return inputBonusNumber().toInt()
    }

    private fun inputBonusNumber(): String {
        println(LottoMessage.BONUS_NUMBER)
        val bonusNumber = Console.readLine()
        println()
        return bonusNumber
    }
}
