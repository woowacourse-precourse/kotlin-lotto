package lotto.Model

class Money() {
    private var money: Int = 0

    constructor(money: Int) : this() {
        if ((money % 1000 != 0) && (money == 0)) {
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        }
        this.money = money
    }

    fun getMoney(): Int {
        return money
    }
}