package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.Constant.Companion.inputWinningMessage
import lotto.Constant.Companion.lottoSize
import lotto.Constant.Companion.maxLottoNumber
import lotto.Constant.Companion.minLottoNumber
import lotto.Constant.Companion.winningDigitErrorMessage
import lotto.Constant.Companion.winningDupleErrorMessage
import lotto.Constant.Companion.winningRangeErrorMessage
import lotto.Constant.Companion.winningRegularErrorMessage

class WinningNumber {
    init {
        println(inputWinningMessage)
    }

    fun inputWinningNumber(): List<Int> {
        val inputWinningNumber: List<String> = readLine().trim().split(',')

        exception(inputWinningNumber)
        return changeType(inputWinningNumber, mutableListOf())
    }

    private fun changeType(inputWinningNumber: List<String>, numberList: MutableList<Int>): List<Int> {
        for (data in inputWinningNumber) {
            numberList.add(data.toInt())
        }
        return numberList
    }

    fun exception(inputWinningNumber: List<String>) {
        sizeException(inputWinningNumber)
        dupleException(inputWinningNumber)
        typeException(inputWinningNumber)
    }

    private fun sizeException(inputWinningNumber: List<String>) {
        if (inputWinningNumber.size != lottoSize) {
            println(winningRegularErrorMessage)
            throw IllegalArgumentException(winningRegularErrorMessage)
        }
    }

    private fun dupleException(inputWinningNumber: List<String>) {
        if (checkDuple(inputWinningNumber)) {
            println(winningDupleErrorMessage)
            throw IllegalArgumentException(winningDupleErrorMessage)
        }
    }

    private fun typeException(inputWinningNumber: List<String>) {
        for (number in inputWinningNumber) {
            if (!isNumeric(number)) {
                println(winningDigitErrorMessage)
                throw IllegalArgumentException(winningDigitErrorMessage)
            }
            if (number.toInt() !in minLottoNumber..maxLottoNumber) {
                println(winningRangeErrorMessage)
                throw IllegalArgumentException(winningRangeErrorMessage)
            }
        }
    }

    private fun checkDuple(inputList: List<String>): Boolean {
        return inputList.size != inputList.distinct().count()
    }

    private fun isNumeric(str: String): Boolean {
        return str.chars().allMatch { Character.isDigit(it) }
    }
}