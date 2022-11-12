package lotto

class LottoGame {
    var money = Money(0)

    fun receiveMoney(money: String) {
        if (!money.all { Character.isDigit(it) })
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        println(money)
        this.money = Money(money.toInt())
    }

}