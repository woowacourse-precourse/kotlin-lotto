package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Print
import lotto.view.Message

class InputLottoPrice {
    fun input() {
        Message.showInput()
        CreateLottoNumber(inputPrice()).create()
    }

    private fun inputPrice(): Int {
        try {
            val realPrice = Console.readLine().trim()
            require(realPrice.all { it.isDigit() } && (realPrice.toInt() % Print.MIN_PRICE) == Print.ZERO)
            return realPrice.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(Print.ERROR_PRICE)
        }
    }
}