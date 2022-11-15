package lotto.domain

import lotto.resource.*
import java.text.DecimalFormat

enum class Winning(
    val countMatching: Int,
    val prize: Int,
    val message: String
) {
    FIFTH(3, PRIZE_FIFTH, WINNING_FIFTH) {
        override fun getTotalPrize(num: Int): Int {
            return num * PRIZE_FIFTH
        }
    },
    FOURTH(4, PRIZE_FOURTH, WINNING_FOURTH) {
        override fun getTotalPrize(num: Int): Int {
            return num * PRIZE_FOURTH
        }
    },
    THIRD(5, PRIZE_THIRD, WINNING_THIRD) {
        override fun getTotalPrize(num: Int): Int {
            return num * PRIZE_THIRD
        }
    },
    SECOND(5, PRIZE_SECOND, WINNING_SECOND) {
        override fun getTotalPrize(num: Int): Int {
            return num * PRIZE_SECOND
        }
    },
    FIRST(6, PRIZE_FIRST, WINNING_FIRST) {
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

        fun printWinnings(winning: List<Int>) {
            enumValues<Winning>().forEach {
                println("${it.message}${formatPrize(it)} - ${winning[it.ordinal]}개")
            }
        }
    }
}