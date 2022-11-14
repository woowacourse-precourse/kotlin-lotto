package lotto

import lotto.view.InputView

class LottoGame {

    fun start() {
        val inputView = InputView()

        val money = inputView.getInputMoney()
        println()

        val winningLotto = inputView.getInputWinningNumber()
        println()

        val bonus = inputView.getInputBonus()
        println()

        val lottoGenerate = LottoGenerate()
        val lottos = Lottos(lottoGenerate.createLottos(money / LOTTO_PRICE))
        lottos.printLottos()
        lottos.printWinningResult(winningLotto, bonus, money)

    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}