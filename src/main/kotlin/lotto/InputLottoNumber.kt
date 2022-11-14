package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Print

class InputLottoNumber {
    fun input(createNumbers: MutableList<List<Int>>, inputPrice: Int) {
        showInputNumberMessage()
        val inputNumbers = inputLotto()
        showInputBonusMessage()
        val bonusNumber = inputBonusNumber(inputNumbers)
        LottoResult(createNumbers, inputPrice).result(inputNumbers, bonusNumber)
    }

    private fun showInputNumberMessage() {
        println(Print.INPUT_NUMBER)
    }

    private fun inputLotto(): List<String> {
        val numbers = Console.readLine().trim().split(Print.NUMBER_SEPARATOR)
        numbers.forEach { number ->
            number.map {
                if (!it.isDigit() ||
                    numbers.distinct().size != Print.LOTTO_NUMBER ||
                    it.code - 48 !in Print.START_NUMBER..Print.END_NUMBER
                ) {
                    throw exception(Print.ERROR_NUMBER)
                }
            }
        }
        return numbers
    }

    private fun showInputBonusMessage() {
        println(Print.INPUT_BONUS)
    }

    private fun inputBonusNumber(inputNumbers: List<String>): String {
        val bonusNumber = Console.readLine().trim()
        if (bonusNumber.all { it.isDigit() } &&
            !inputNumbers.contains(bonusNumber) &&
            bonusNumber.toInt() in Print.START_NUMBER..Print.END_NUMBER) {
            return bonusNumber
        } else {
            throw exception(Print.ERROR_BONUS)
        }
    }

    private fun exception(error: String) = IllegalArgumentException(error)
}
