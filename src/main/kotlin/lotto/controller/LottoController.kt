package lotto.controller

import lotto.domain.*
import lotto.view.LottoView

class LottoController {

    private val lottoView = LottoView()
    private val lottoGenerator = LottoGenerator()

    fun start() {
        val inputMoney = lottoView.getInputMoney()
        val lottoMoneyManager = LottoMoney(inputMoney)
        val numberOfIssueLotto = lottoMoneyManager.getPurchaseLottoAmount()
        val issuedLottos = lottoGenerator.issueLottos(numberOfIssueLotto)
        lottoView.printIssuedLottos(issuedLottos, numberOfIssueLotto)
        val inputWinningLottoNumber = lottoView.inputWinningLottoNumbers()
        val winningLottoNumbers = Lotto(inputWinningLottoNumber)
        val bonusNumber = lottoView.inputBonusNumber()

        val winningLotto = WinningLotto(winningLottoNumbers, bonusNumber)
        val lottoRankingResult = issuedLottos.matchingLottoNum(winningLotto)
        val lottoResult = LottoWinResult().getLottoResult(lottoRankingResult)
        lottoView.printResult(lottoResult)
        lottoView.printYieldRate(inputMoney, lottoResult)
    }
}