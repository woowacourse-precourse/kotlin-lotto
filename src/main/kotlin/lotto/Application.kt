package lotto

import data.*
import ui.Input

fun main() {
    val calc = LottoCalculation()

    val price: Int = Input().price()
    purchasesNumber = price / 1000
    val lottoList: List<List<Int>> = LottoCalculation().generateRandomLotto(purchasesNumber)
    println(PRINT_MESSAGE_PURCHASES_NUMBER)
    println(lottoList)
    val jackpot: List<Int> = Input().jackpot()
    val bonus: Int = Input().bonus()
    val countJackpot: List<Int> = calc.countJackpot(lottoList, jackpot, bonus)
    val prize: Long = calc.calculatePrize(countJackpot)
    val rateOfReturn: Double = calc.rateOfReturn(price, prize)
    println(rateOfReturn)
}
