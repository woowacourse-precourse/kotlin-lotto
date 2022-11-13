package lotto.controller

import lotto.domain.*
import lotto.view.LottoView

class LottoController {

    private val lottoView = LottoView()

    fun start() {
        val inputMoney = getInputMoney()
        val numberOfIssueLotto = numberOfLotto(inputMoney)
        val issuedLottoList = issueLottos(numberOfIssueLotto)
        lottoView.printIssuedLottos(issuedLottoList, numberOfIssueLotto)
        val inputWinningLottoNumber = lottoView.getWinningLotto()
        val winningLottoNumList = Lotto(inputWinningLottoNumber)
        val bonusNumber = getBonusNumber()

        val winningLotto = WinningLotto(winningLottoNumList, bonusNumber)
        val lottoRankingResultList = issuedLottoList.matchingLottoNum(winningLotto)
        val lottoResult = LottoWinResult().getLottoResult(lottoRankingResultList)
    }

    private fun getInputMoney(): Int {
        var inputMoney = 0
        try {
            inputMoney = lottoView.getInputMoney()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
        return inputMoney
    }

    private fun getBonusNumber(): Int {
        var bonusNumber = 0
        try {
            bonusNumber = lottoView.getBonusNumber()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
        return bonusNumber
    }

    private fun issueLottos(inputMoney: Int): Lottos {
        return LottoGenerator().issueLottos(inputMoney)
    }

    private fun numberOfLotto(money: Int): Int {
        return money / PRICE_PER_LOTTO
    }

    companion object {
        const val PRICE_PER_LOTTO = 1000
    }
}