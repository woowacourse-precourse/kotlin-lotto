package lotto.domain.controller.winning

import lotto.domain.model.winning.WinningLotto
import lotto.ui.view.winning.MakeWinningNumberView

class MakeWinningNumberController(private val makeWinningNumberView: MakeWinningNumberView) {
    private lateinit var winningLotto: WinningLotto

    fun run() {
        val winningNumbers =
            makeWinningNumberView.enterWinningNumber().split(",").map { it.toInt() }
        val bonusNumber = makeWinningNumberView.enterBonusNumber().toInt()

        winningLotto = WinningLotto(winningNumbers, bonusNumber)
    }
}