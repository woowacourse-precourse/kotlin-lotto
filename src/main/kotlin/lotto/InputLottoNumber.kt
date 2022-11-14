package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Print
import lotto.view.Message

class InputLottoNumber {
    fun input(createNumbers: MutableList<List<Int>>, inputPrice: Int) {
        Message.showInputNumber()
        val inputNumbers = inputLotto()
        Message.showInputBonus()
        val bonusNumber = inputBonusNumber(inputNumbers)
        LottoResult(createNumbers, inputPrice).result(inputNumbers, bonusNumber)
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

    private fun inputBonusNumber(inputNumbers: List<String>): String {
        try {
            val bonusNumber = Console.readLine().trim()
            require(bonusNumber.all { it.isDigit() } &&
                    !inputNumbers.contains(bonusNumber) &&
                    bonusNumber.toInt() in Print.START_NUMBER..Print.END_NUMBER)
            return bonusNumber
        } catch (e: IllegalArgumentException) {
            throw exception(Print.ERROR_BONUS)
        }

    }

    private fun exception(error: String) = IllegalArgumentException(error)
}
