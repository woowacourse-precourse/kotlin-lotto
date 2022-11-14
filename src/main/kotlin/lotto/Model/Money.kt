package lotto.Model

class Money() {
    private var money: Int = -1

    constructor(money: Int) : this() {
        this.money = money
    }

    fun getMoney(): Int {
        return money
    }
}