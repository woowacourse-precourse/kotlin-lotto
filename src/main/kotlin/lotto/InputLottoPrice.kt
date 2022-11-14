package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Print

class InputLottoPrice {
    fun input() {
        showInputMessage()
        CreateLottoNumber(inputPrice()).create()
    }

    private fun showInputMessage() {
        println(Print.INPUT_PRICE)
    }

    private fun inputPrice(): Int {
        try {
            val realPrice = Console.readLine().trim()
            require(realPrice.all { it.isDigit() } && realPrice.toInt() % 1000 == 0)
            return realPrice.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(Print.ERROR_PRICE)
        }
    }
}