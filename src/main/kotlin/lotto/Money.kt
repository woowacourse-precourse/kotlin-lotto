package lotto

class Money {

    val money : Int

    constructor(money : String) {

        require(money.matches(Regex("\\d+"))) {println("[ERROR] 돈은 숫자로만 이루어져야 합니다.")}
        require(money.toInt() % 1000 == 0) {println("[ERROR] 돈은 1000으로 나누어져야합니다.")}
        this.money = money.toInt()
    }

    fun getCountLotto() : Int = money / LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1000
    }
}