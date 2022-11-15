package lotto

enum class LottoResult(private val winMoney: Int) {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NOTHING(0);

    fun getWinMoney() = winMoney
}