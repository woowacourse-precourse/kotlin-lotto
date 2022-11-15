package lotto

import lotto.domain.Bank
import lotto.domain.LottoMarket

fun main() {
    val lottoMarket = LottoMarket()
    val ui = UI()
    val bank: Bank

    try {
        ui.printRequestPurchasingAmount()
        val purchasingAmount = ui.inputPurchasingAmount()
        ui.printBlankLine()

        val theNumberOfLotto = lottoMarket.getTheNumberOfLotto(purchasingAmount)
        ui.printTheNumberOfLotto(theNumberOfLotto)
        val lottos = lottoMarket.buyLottos(theNumberOfLotto)
        ui.printLottos(lottos)
        ui.printBlankLine()

        ui.printRequestWinNumbers()
        val winNumbers = ui.inputWinNumbers()
        ui.printBlankLine()

        ui.printRequestBonusNumber()
        val bonusNumber = ui.inputBonusNumber()
        ui.printBlankLine()

        bank = Bank(lottos)
        bank.writeWinStatistic(winNumbers, bonusNumber)
        ui.printTotalWinStatistic(bank.winStatistic)

        val totalIncome = bank.getTotalIncome()
        val rateOfReturn = bank.getRateOfReturn(totalIncome, purchasingAmount)
        ui.printRateOfReturn(rateOfReturn)
    } catch (error : Exception){
        println(error.toString())
    }

}
