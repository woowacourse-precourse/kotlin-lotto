package lotto.domain

enum class MatchingCount(val profit: Int) {
    THREE(5000), FOUR(50000), FIVE(1500000), FIVE_BONUS(30000000), SIX(2000000000), ETC(0)
}