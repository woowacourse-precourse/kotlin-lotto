package view

import util.printAskWinBonusNumberInput
import util.printAskWinLottoNumbersInput

class EnterpriseUI {
    fun showUI(ui: UI) {
        when (ui) {
            UI.ASK_WIN_LOTTO_NUMBERS_INPUT -> printAskWinLottoNumbersInput()
            UI.ASK_WIN_LOTTO_BONUS_NUMBER_INPUT -> printAskWinBonusNumberInput()
        }
    }

    companion object {
        enum class UI {
            ASK_WIN_LOTTO_NUMBERS_INPUT,
            ASK_WIN_LOTTO_BONUS_NUMBER_INPUT
        }
    }
}