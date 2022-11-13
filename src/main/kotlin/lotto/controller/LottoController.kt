package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.Lottos
import lotto.view.LottoView

class LottoController {

    private val lottoView = LottoView()

    fun start() {
        var inputMoney = 0
        try {
            val inputMoney = lottoView.getInputMoney()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }

        val numberOfIssueLotto = numberOfLotto(inputMoney)
        val issuedLottoList = issueLottos(numberOfIssueLotto)
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