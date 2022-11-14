package lotto.domain

import lotto.resources.*

enum class LottoRank(
    val numberOfSame: Int,
    val bonus: Boolean,
    val prize: Int
) {
    FIRST(LOTTO_NUMBER_COUNT, false, LOTTO_FIRST_PRIZE),
    SECOND(LOTTO_NUMBER_COUNT - 1, true, LOTTO_SECOND_PRIZE),
    THIRD(LOTTO_NUMBER_COUNT - 1, false, LOTTO_THIRD_PRIZE),
    FOURTH(LOTTO_NUMBER_COUNT - 2, false, LOTTO_FOURTH_PRIZE),
    FIFTH(LOTTO_NUMBER_COUNT - 3, false, LOTTO_FIFTH_PRIZE),
    NONE(LOTTO_NUMBER_COUNT - 4, false, LOTTO_NONE_PRIZE);

    companion object {
        fun of(numberOfSame: Int, bonus: Boolean): LottoRank {
            return values().firstOrNull {
                it.numberOfSame == numberOfSame && it.bonus == bonus
            } ?: NONE
        }
    }
}
