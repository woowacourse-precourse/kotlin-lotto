package lotto

class Money {

    val money : Int

    constructor(money : String?) {
        require(money != null) { println( MONEY_NULL_ERROR_MSG )}
        require(money.matches(Regex("\\d+"))) { println(MONEY_VALUE_ERROR_MSG) }
        require(money.toInt() % 1000 == 0) {println(MONEY_RANGE_ERROR_MSG)}
        this.money = money.toInt()
    }

    fun getCountLotto() : Int = money / LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1000
        const val MONEY_NULL_ERROR_MSG = "[ERROR] 돈이 입력되지 않았습니다."
        const val MONEY_VALUE_ERROR_MSG = "[ERROR] 돈은 숫자로만 이루어져야 합니다."
        const val MONEY_RANGE_ERROR_MSG = "[ERROR] 돈은 1000으로 나누어져야합니다."
    }
}