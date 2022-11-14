package lotto

import data.*
import ui.Input

fun main() {
    val calc = LottoCalculation()
    val input = Input()

    val price: Int = input.price()
    purchasesNumber = price / 1000
    val lottoList: List<List<Int>> = LottoCalculation().generateRandomLotto(purchasesNumber)
    println(PRINT_MESSAGE_PURCHASES_NUMBER)
    println(lottoList)
    val jackpot: List<Int> = input.jackpot()
    val bonus: Int = input.bonus()
    val countJackpot: List<Int> = calc.countJackpot(lottoList, jackpot, bonus)
    val prize: Long = calc.calculatePrize(countJackpot)
    val rateOfReturn: Double = calc.rateOfReturn(price, prize)
    println(rateOfReturn)
}
