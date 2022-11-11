package lotto.domain.controller.winning

import lotto.domain.controller.Controller
import lotto.domain.model.winning.WinningLotto
import lotto.ui.view.winning.MakeWinningNumberView

class MakeWinningNumberController(
    private val makeWinningNumberView: MakeWinningNumberView,
    private val winningLotto: WinningLotto
): Controller() {
    private var _winningNumbers = winningLotto.winningNumbers
    private var _bonusNumber = winningLotto.bonusNumber

    override fun run() {
        // 당첨 번호를 입력받는다.
        enterWinningNumberInfo()

        // 입력 받은 번호로 당첨 로또 정보 생성
        updateWinningLotto()
    }

    private fun enterWinningNumberInfo() {
        _winningNumbers = makeWinningNumberView.enterWinningNumber().split(",").map { it.toInt() }
        _bonusNumber = makeWinningNumberView.enterBonusNumber().toInt()

        // TODO: 입력 번호 검증
    }

    private fun updateWinningLotto() {
        winningLotto.apply {
            winningNumbers = _winningNumbers
            bonusNumber = _bonusNumber
        }
    }
}