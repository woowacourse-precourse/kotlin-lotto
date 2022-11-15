package lotto.domain.controller.winning

import lotto.domain.controller.Controller
import lotto.domain.model.winning.WinningLotto
import lotto.domain.validator.InputValidator
import lotto.ui.view.winning.MakeWinningNumberView

class MakeWinningNumberController(
    private val makeWinningNumberView: MakeWinningNumberView,
    private val winningLotto: WinningLotto
): Controller() {

    override fun run() {
        // 당첨 번호를 입력받는다.
        enterWinningNumberInfo()
    }

    private fun enterWinningNumberInfo() {
        val inputWinningNumbers = makeWinningNumberView.enterWinningNumber()
        checkWinningNumbersInput(inputWinningNumbers)

        val inputBonusNumber = makeWinningNumberView.enterBonusNumber()
        checkBonusNumberInput(inputBonusNumber)
    }

    private fun checkWinningNumbersInput(inputWinningNumbers: String) {
        val errorType = InputValidator.validateWinningLottoNumbers(inputWinningNumbers)
        makeWinningNumberView.printErrorMessage(errorType)

        winningLotto.winningNumbers = inputWinningNumbers.split(",").map { it.toInt() }
    }

    private fun checkBonusNumberInput(inputBonusNumber: String) {
        val errorType = InputValidator.validateBonusLottoNumber(winningLotto.winningNumbers, inputBonusNumber)
        makeWinningNumberView.printErrorMessage(errorType)

        winningLotto.bonusNumber = inputBonusNumber.toInt()
    }
}