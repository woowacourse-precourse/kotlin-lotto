package lotto

class LottoGame {

    fun start() {
        val inputView = InputView()
        val money = inputView.getInputMoney()
        val winningLotto = inputView.getInputWinningNumber()
        val bonus = inputView.getInputBonus()

        val lottoGenerate = LottoGenerate()
        val lotto = lottoGenerate.createLottos(money / LOTTO_PRICE)

        val lottos = Lottos(lotto)
        lottos.printLottos()
        lottos.printWinningResult(winningLotto, bonus, money)

    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}