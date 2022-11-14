package lotto.domain

import java.lang.IllegalArgumentException

enum class Rank(private val count: Int, private val price: Int) {
    FAIL(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    fun getCount(): Int {
        return count
    }

    fun getPrice(): Int {
        return price
    }

    private fun compareTo(count: Int): Boolean {
        return this.getCount() == count
    }

    companion object {
        private const val WINNING_MIN_COUNT = 3

        fun valueOf(matchedCount: Int, checkBonus: Boolean): Rank {
            if (matchedCount < WINNING_MIN_COUNT) {
                return FAIL
            }
            if (SECOND.compareTo(matchedCount) && checkBonus) {
                return SECOND
            }

            for (rank in values()) {
                if (rank.compareTo(matchedCount) && rank != SECOND) {
                    return rank
                }
            }

            throw IllegalArgumentException("[ERROR] 유효한 값이 없습니다.")
        }
    }
}
