package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Constant
import lotto.constants.Exception
import lotto.views.InputView
import lotto.views.OutputView

class Purchase {
    init {
        OutputView.printInputMoney()
    }

    fun buyLotto(): Int {
        val money = InputView.inputMoney()
        validateMoney(money)
        return money / Constant.MONEY_UNIT
    }

    fun validateMoney(money: Int) {
        if (money % 1000 != 0) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_MONEY)
        }
    }
}