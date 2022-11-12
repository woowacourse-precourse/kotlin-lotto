package lotto.controller

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
    }

    private fun numberOfLotto(money: Int): Int {
        return money / PRICE_PER_LOTTO
    }

    companion object {
        const val PRICE_PER_LOTTO = 1000
    }
}