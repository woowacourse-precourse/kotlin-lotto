package lotto.domain

import lotto.domain.NumberGenerator.Companion.LOTTO_NUMBER_COUNT

private const val LOTTO_FIRST_PRIZE = 2_000_000_000
private const val LOTTO_SECOND_PRIZE = 30_000_000
private const val LOTTO_THIRD_PRIZE = 1_500_000
private const val LOTTO_FOURTH_PRIZE = 50_000
private const val LOTTO_FIFTH_PRIZE = 5_000
private const val LOTTO_NONE_PRIZE = 0

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
            return values().filter {
                it.numberOfSame == numberOfSame &&
                it.bonus == bonus
            }.getOrElse(0) { NONE }
        }
    }
}
