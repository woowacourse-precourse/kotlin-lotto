package lotto

import data.PRINT_MESSAGE_PURCHASES_NUMBER
import data.purchasesNumber

fun main() {
    val calc = LottoCalculation()

    val price: Int = ValueInput().price()
    purchasesNumber = price / 1000
    val lottoList: List<List<Int>> = LottoCalculation().generateRandomLotto(purchasesNumber)
    println(PRINT_MESSAGE_PURCHASES_NUMBER)
    println(lottoList)
    val jackpot: List<Int> = ValueInput().jackpot()
    val bonus: Int = ValueInput().bonus()
    val countJackpot: List<Int> = calc.countJackpot(lottoList, jackpot, bonus)
    val prize: Long = calc.calculatePrize(countJackpot)
    val rateOfReturn: Double = calc.rateOfReturn(price, prize)
    println(rateOfReturn)
}
