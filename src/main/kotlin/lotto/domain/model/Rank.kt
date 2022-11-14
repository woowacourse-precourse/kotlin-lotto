package lotto.domain.model

import lotto.controller.LottoController.Companion.ERROR_MESSAGE

enum class Rank(private val correctCnt: Int) {
    CORRECT_ZERO(0) {
        override val prize: Int = 0
    },
    CORRECT_THREE(3) {
        override val prize: Int = 5_000
    },
    CORRECT_FOUR(4) {
        override val prize: Int = 50_000
    },
    CORRECT_FIVE(5) {
        override val prize: Int = 50_000
    },
    CORRECT_FIVE_BONUS(5) {
        override val prize: Int = 50_000
    },
    CORRECT_SIX(6) {
        override val prize: Int = 50_000
    };

    abstract val prize: Int

    fun compareCnt(cnt: Int): Boolean = this.correctCnt == cnt

    companion object {
        fun valueOf(correctCnt: Int, checkBonus: Boolean): Rank {
            if (correctCnt < 3) {
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