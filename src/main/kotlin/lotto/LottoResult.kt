package lotto

enum class LottoResult(val reward: Int) {
    NOTHING(0),
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_BONUS(30000000),
    SIX(2000000000)
}