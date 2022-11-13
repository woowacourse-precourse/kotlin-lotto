package lotto

class Money {

    val money : Int

    constructor(money : String) {

        if (!money.matches(Regex("\\d+"))) {
                println("[ERROR] 돈은 숫자로만 이루어져야 합니다.")
                throw IllegalArgumentException("[ERROR]")
        }

        require(money.toInt() % 1000 == 0) {println("[ERROR]")}
        this.money = money.toInt()
    }

    fun getCountLotto() : Int = money / LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1000
    }
}