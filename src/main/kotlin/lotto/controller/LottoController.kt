package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.Lottos
import lotto.view.LottoView

class LottoController {

    private val lottoView = LottoView()

    fun start() {
        val inputMoney = getInputMoney()
        val numberOfIssueLotto = numberOfLotto(inputMoney)
        val issuedLottoList = issueLottos(numberOfIssueLotto)
        val winningLottoNumber = lottoView.getWinningLotto()
        val winnigLotto = Lotto(winningLottoNumber)
        val bonusNumber = getBonusNumber()
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