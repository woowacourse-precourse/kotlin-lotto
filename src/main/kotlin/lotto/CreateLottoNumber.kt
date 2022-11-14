package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Print

class CreateLottoNumber(
    private val inputPrice: Int
) {
    fun create() {
        showBuyMessage()
        InputLottoNumber().input(createNumber(), inputPrice)
    }

    private fun showBuyMessage() {
        println("\n${inputPrice / Print.MIN_PRICE}${Print.BUY_COUNT}")
    }

    private fun createNumber(): MutableList<List<Int>> {
        val numbers = mutableListOf<List<Int>>()
        for (index in Print.ZERO until inputPrice / Print.MIN_PRICE) {
            val randomNumber =
                Randoms.pickUniqueNumbersInRange(Print.START_NUMBER, Print.END_NUMBER, Print.LOTTO_NUMBER)
            numbers.addAll(listOf(Lotto(randomNumber).show()))
        }
        return numbers
    }
}
