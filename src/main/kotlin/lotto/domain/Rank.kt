package lotto.domain

enum class Rank(val prize: Long, val message: String) {
    FIRST(2000000000L, "6개 일치"),
    SECOND(30000000L, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000L, "5개 일치"),
    FOURTH(50000L, "4개 일치"),
    FIFTH(5000L, "3개 일치");

    fun getPrize(winners: Int): Long {
        return prize * winners
    }
}