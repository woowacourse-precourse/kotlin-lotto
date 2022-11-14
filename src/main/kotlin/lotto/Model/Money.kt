package lotto.Model

import lotto.ValidateInput

class Money(money: Int) {
    private var money: Int = -1

    init {
        if (ValidateInput().validateMoney(money))
            this.money = money
    }

    fun getMoney(): Int {
        return money
    }
}