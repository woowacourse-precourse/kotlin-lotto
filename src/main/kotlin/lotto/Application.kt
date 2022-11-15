package lotto

import values.*
import ui.InputHandler
import ui.OutputHandler

fun main() {
    val calc = LottoCalculation()
    val inputHandler = InputHandler()
    val outputHandler = OutputHandler()

    val price: Int = inputHandler.price()
    val purchasesNumber = calc.priceToCount(price)
    val lottoList: List<List<Int>> = LottoCalculation().generateRandomLotto(purchasesNumber)

    outputHandler.lottoStatus(lottoList, purchasesNumber)

    val jackpot: List<Int> = inputHandler.jackpot()
    val bonus: Int = inputHandler.bonus()

    outputHandler.totalStatus(lottoList, jackpot, bonus, price)
}
