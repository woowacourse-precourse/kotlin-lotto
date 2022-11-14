package lotto.view

import lotto.utils.Print

object Message {
    fun showInput() {
        println(Print.INPUT_PRICE)
    }

    fun showBuy(inputPrice: Int) {
        println("\n${inputPrice / Print.MIN_PRICE}${Print.BUY_COUNT}")
    }

    fun showInputNumber() {
        println(Print.INPUT_NUMBER)
    }

    fun showInputBonus() {
        println(Print.INPUT_BONUS)
    }

    fun showTitle() {
        println(Print.RESULT_TITLE)
        println("---")
    }

    fun showRate(rate: Double) {
        println("총 수익률은 $rate%입니다.")
    }

    fun showCorrect(message: String, count: Int) {
        println("${message}${count}개")
    }

    fun showLottoNumber(numbers: List<Int>) {
        println(numbers.sorted())
    }
}