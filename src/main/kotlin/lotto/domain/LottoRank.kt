package lotto.domain

import lotto.domain.NumberGenerator.Companion.LOTTO_NUMBER_COUNT

enum class LottoRank(
    val numberOfSame: Int,
    val bonus: Boolean,
    val prize: Int
) {
    FIRST(LOTTO_NUMBER_COUNT, false, 2_000_000_000),
    SECOND(LOTTO_NUMBER_COUNT - 1, true, 30_000_000),
    THIRD(LOTTO_NUMBER_COUNT - 1, false, 1_500_000),
    FOURTH(LOTTO_NUMBER_COUNT - 2, false, 50_000),
    FIFTH(LOTTO_NUMBER_COUNT - 3, false, 5_000),
    NONE(LOTTO_NUMBER_COUNT - 4, false, 0);

    companion object {
        fun of(numberOfSame: Int, bonus: Boolean): LottoRank {
            return values().filter {
                it.numberOfSame == numberOfSame &&
                it.bonus == bonus
            }.getOrElse(0) { NONE }
        }
    }
}
