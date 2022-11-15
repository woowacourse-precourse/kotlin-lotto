package lotto.controller

import lotto.model.LottoData.clearData
import lotto.util.Statistics.processStatistics
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    init {
        clearData()
    }

    fun start() {
        inputView.inputPurchaseAmount()
        outputView.printPublishedLotto()
        inputView.inputWinningNumber()
        inputView.inputBonusNumber()
        processStatistics()
        outputView.printWinningStats()
    }
}