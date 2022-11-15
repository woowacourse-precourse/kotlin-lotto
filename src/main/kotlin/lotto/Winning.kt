package lotto

import resource.*
import java.text.DecimalFormat

enum class Winning(
    val countMatching: Int,
    val prize: Int
) {
    FIFTH(3, PRIZE_FIFTH) {
        override fun getTotalPrize(num: Int): Int {
            return num * PRIZE_FIFTH
        }
    },
    FOURTH(4, PRIZE_FOURTH) {
        override fun getTotalPrize(num: Int): Int {
            return num * PRIZE_FOURTH
        }
    },
    THIRD(5, PRIZE_THIRD) {
        override fun getTotalPrize(num: Int): Int {
            return num * PRIZE_THIRD
        }
    },
    SECOND(5, PRIZE_SECOND) {
        override fun getTotalPrize(num: Int): Int {
            return num * PRIZE_SECOND
        }
    },
    FIRST(6, PRIZE_FIRST) {
        override fun getTotalPrize(num: Int): Int {
            return num * PRIZE_FIRST
        }
    };

    abstract fun getTotalPrize(num: Int): Int

    companion object {
        private val format = DecimalFormat("#,###")

        fun formatPrize(winning: Winning): String {
            return "(${format.format(winning.prize)}원)"
        }

        fun getAllPrize(winning: List<Int>): Int {
            var sum = 0

            for (i in winning.indices) {
                sum += enumValues<Winning>()[i].getTotalPrize(winning[i])
            }

            return sum
        }
    }
}