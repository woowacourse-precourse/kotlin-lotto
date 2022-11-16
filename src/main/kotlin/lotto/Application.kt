package lotto

import ui.InputHandler
import ui.OutputHandler

fun main() {
    try {
        val calc = LottoCalculator()
        val inputHandler = InputHandler()
        val outputHandler = OutputHandler()

        val price: Int = inputHandler.price()
        val purchasesNumber = calc.priceToCount(price)
        val lottoList: List<List<Int>> = LottoCalculator().generateRandomLotto(purchasesNumber)

        outputHandler.lottoStatus(lottoList, purchasesNumber)

        val jackpot: List<Int> = inputHandler.jackpot()
        val bonus: Int = inputHandler.bonus()

        outputHandler.totalStatus(lottoList, jackpot, bonus, price)

    } catch (e: Exception) {
        println("[ERROR]")
    }
}
