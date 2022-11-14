package lotto.domain.model

import lotto.domain.model.Lotto.Companion.ERROR_MESSAGE

enum class Prize {
    CORRECT_THREE,
    CORRECT_FOUR,
    CORRECT_FIVE,
    CORRECT_SIX;

    companion object {
        fun create(correctNum: Int): Prize {
            return when (correctNum) {
                3 -> CORRECT_THREE
                4 -> CORRECT_FOUR
                5 -> CORRECT_FIVE
                6 -> CORRECT_SIX
                else -> throw IllegalStateException("$ERROR_MESSAGE 당첨 갯수가 잘못됐습니다.")
            }
        }
    }
}

