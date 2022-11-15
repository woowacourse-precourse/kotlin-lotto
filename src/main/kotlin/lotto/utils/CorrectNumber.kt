package lotto.utils

enum class CorrectNumber(
    private val money: Int
) {
    THREE(5000),
    FOUR(50_000),
    FIVE(1_500_000),
    FIVE_AND_BONUS(30_000_000),
    SIX(2_000_000_000);

    fun getMoney(): Int = money

}