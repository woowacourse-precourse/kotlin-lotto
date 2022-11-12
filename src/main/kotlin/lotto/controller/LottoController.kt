package lotto.controller

import lotto.view.LottoView

class LottoController {

    private val lottoView = LottoView()

    fun start() {
        try {
            val inputMoney = lottoView.getInputMoney()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}