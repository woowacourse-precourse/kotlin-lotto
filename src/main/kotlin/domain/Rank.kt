package domain

import java.util.*
import kotlin.streams.toList

enum class Rank(val rank: Int, val reward: Int) {
    FIRST_PLACE(6, 2_000_000_000), SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    NOTHING(0, 0);

    companion object {
        fun getRank(rank: Int, hasBonusBall: Boolean): Rank {
            val checkRank = Arrays.stream(values())
                .filter { it.rank == rank }
                .findFirst()
                .orElse(NOTHING)
            if (rank == THIRD_PLACE_BALL && !hasBonusBall) {
                return THIRD_PLACE
            }
            return checkRank
        }

        fun getValues(): List<Rank> {
            return Arrays.stream(values())
                .filter { it !== NOTHING }.toList()
        }

        private const val THIRD_PLACE_BALL = 5
    }
}
