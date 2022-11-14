package lotto.controller

import lotto.domain.Lotto
import lotto.domain.Judgement
import lotto.domain.LottoGenerator
import lotto.domain.YieldCalculator
import lotto.view.InputView
import lotto.view.OutputView

class LottoGameController {
    private var lottoMoney = 0
    private lateinit var lottos: List<Lotto>
    private lateinit var winningLotto: Lotto
    private var bonusNumber = 0

    fun game() {
        try {
            lottoMoney = InputView.getLottoMoney()
            makeLottos(lottoMoney / 1000)
            winningLotto = InputView.getWinningLotto()
            bonusNumber = InputView.getBonusNumber(winningLotto)
            makeLottoResult()
        } catch (e: IllegalArgumentException) {
            OutputView.printErrorMessage(e.message.toString())
            return
        }
    }

    fun makeLottos(lottoCount: Int) {
        OutputView.printLottoCountMessage(lottoCount)
        val lottoGenerator = LottoGenerator()
        lottos = lottoGenerator.generate(lottoCount)
        OutputView.printLottos(lottos)
    }

    fun makeLottoResult() {
        val rank = getRank()
        val yieldValue = calculateYield(rank)
        OutputView.printLottoResult(rank)
        OutputView.printYield(yieldValue)
    }

    fun getRank(): List<Int> {
        val judgement = Judgement()
        return judgement.getRank(winningLotto, bonusNumber, lottos)
    }

    fun calculateYield(rank: List<Int>): Double {
        val yieldController = YieldCalculator()
        val winMoney = yieldController.getWinMoney(rank)
        return yieldController.getYield(winMoney, lottoMoney)
    }

}
