package lotto.domain.model

import lotto.utils.Constants.ERROR_MESSAGE
import lotto.utils.Constants.PRIZE_FIVE
import lotto.utils.Constants.PRIZE_FIVE_BONUS
import lotto.utils.Constants.PRIZE_FOUR
import lotto.utils.Constants.PRIZE_SIX
import lotto.utils.Constants.PRIZE_THREE
import lotto.utils.Constants.ZERO
import java.text.DecimalFormat

enum class Rank(private val correctCnt: Int) {
    CORRECT_ZERO(0) {
        override val prize: Int = ZERO
    },
    CORRECT_THREE(3) {
        override val prize: Int = PRIZE_THREE
    },
    CORRECT_FOUR(4) {
        override val prize: Int = PRIZE_FOUR
    },
    CORRECT_FIVE(5) {
        override val prize: Int = PRIZE_FIVE
    },
    CORRECT_FIVE_BONUS(5) {
        override val prize: Int = PRIZE_FIVE_BONUS
    },
    CORRECT_SIX(6) {
        override val prize: Int = PRIZE_SIX
    };

    abstract val prize: Int
    fun getFormatedPrize(): String = String.format(dec.format(this.prize))

    fun compareCnt(cnt: Int): Boolean = this.correctCnt == cnt

    fun getCount(): Int = this.correctCnt

    companion object {
        val dec = DecimalFormat("#,###")

        private const val MIN_CORRECT_COUNT = 3
        fun valueOf(correctCnt: Int, checkBonus: Boolean): Rank {
            if (correctCnt < MIN_CORRECT_COUNT) {
                return CORRECT_ZERO
            }
            if (CORRECT_FIVE.compareCnt(correctCnt) && checkBonus) {
                return CORRECT_FIVE_BONUS
            }

            for (rank in values()) {
                if (rank.compareCnt(correctCnt) && rank != CORRECT_FIVE_BONUS) {
                    return rank
                }
            }

            throw IllegalArgumentException("$ERROR_MESSAGE 잘못된 일치 번호입니다.")
        }
    }
}