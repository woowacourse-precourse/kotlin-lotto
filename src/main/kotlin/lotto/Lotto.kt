package lotto

import lotto.utils.Print
import lotto.view.Message

class Lotto(
    private val numbers: List<Int>
) {
    init {
        try {
            require(numbers.distinct().size == 6 && numbers.all { it in Print.START_NUMBER..Print.END_NUMBER })
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(Print.ERROR_CREATE)
        }
    }

    fun show(): List<Int> {
        Message.showLottoNumber(numbers)
        return numbers
    }
}
