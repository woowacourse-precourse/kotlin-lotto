package lotto.domain

import lotto.utils.*

enum class LottoRank(
    val message: String,
    val reward: Int
) {
    NO_LUCK(LOTTO_NO_LUCK_MESSAGE, 0),
    FIRST(LOTTO_FIRST_RANK_MESSAGE, 2_000_000_000),
    SECOND(LOTTO_SECOND_RANK_MESSAGE, 30_000_000),
    THIRD(LOTTO_THIRD_RANK_MESSAGE, 1_500_000),
    FOURTH(LOTTO_FOURTH_RANK_MESSAGE, 50_000),
    FIFTH(LOTTO_FIFTH_RANK_MESSAGE, 5_000);
}