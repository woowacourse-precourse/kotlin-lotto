package lotto.Model

import lotto.View.OutputView
import lotto.constants.ERROR_WRONG_MONEY

class Money(money: Int) {
    private var money: Int = -1

    init {
        if (validateMoney(money))
            this.money = money
    }

    fun getMoney(): Int {
        return money
    }

    private fun validateMoney(money: Int): Boolean {
        if ((money % 1000 != 0) || (money == 0)) {
            OutputView().printErrorMessage(ERROR_WRONG_MONEY)
            throw IllegalArgumentException()
        }
        return true
    }
}