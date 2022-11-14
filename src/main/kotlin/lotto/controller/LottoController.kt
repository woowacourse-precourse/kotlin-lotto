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
        val issuedLottoList = lottoGenerator.issueLottos(numberOfIssueLotto)
        lottoView.printIssuedLottos(issuedLottoList, numberOfIssueLotto)
        val inputWinningLottoNumber = lottoView.getWinningLotto()
        val winningLottoNumList = Lotto(inputWinningLottoNumber)
        val bonusNumber = lottoView.getBonusNumber()

        val winningLotto = WinningLotto(winningLottoNumList, bonusNumber)
        val lottoRankingResultList = issuedLottoList.matchingLottoNum(winningLotto)
        val lottoResult = LottoWinResult().getLottoResult(lottoRankingResultList)
        lottoView.printResult(lottoResult)
        lottoView.printYieldRate(inputMoney, lottoResult)
    }
}