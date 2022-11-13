package domain

import java.util.*

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
            if (rank == 5 && !hasBonusBall) {
                return THIRD_PLACE
            }
            return checkRank
        }
    }
}
