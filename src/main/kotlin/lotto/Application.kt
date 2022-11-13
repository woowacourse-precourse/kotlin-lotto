package lotto

import lotto.View.OutputView

fun main() {
    val game = LottoController()
    try {
        game.receiveMoney()

        game.createLotto()

        game.receiveWinningNumber()

        game.receiveBonusNumber()

        game.concludePrizeResult()

        game.concludeEarningRate()
    } catch (e: IllegalArgumentException) {
        OutputView().printErrorMessage()
        return
    }
}
