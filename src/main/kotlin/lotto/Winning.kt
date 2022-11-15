package lotto

import resource.*
import java.text.DecimalFormat

enum class Winning(
    val countMatching: Int,
    val prize: Int
) {
    FIFTH(3, PRIZE_FIFTH),
    FOURTH(4, PRIZE_FOURTH),
    THIRD(5, PRIZE_THIRD),
    SECOND(5, PRIZE_SECOND),
    FIRST(6, PRIZE_FIRST);

    companion object {
        private val format = DecimalFormat("#,###")

        fun formatPrize(winning: Winning): String {
            return "(${format.format(winning.prize)}원)"
        }
    }
}