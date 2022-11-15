package lotto

import lotto.Units.Companion.GRADE_FOURTH
import lotto.Units.Companion.GRADE_FIRST
import lotto.Units.Companion.REWARD_FIRST
import lotto.Units.Companion.REWARD_FOURTH
import lotto.Units.Companion.REWARD_SECOND
import lotto.Units.Companion.REWARD_THIRD
import lotto.Units.Companion.GRADE_THIRD
import lotto.Units.Companion.GRADE_SECOND

enum class Rank(
    val ranking: Int,
    val reward: Int
) {
    FIRST(GRADE_FIRST, REWARD_FIRST),
    SECOND(GRADE_SECOND, REWARD_SECOND),
    THIRD(GRADE_THIRD, REWARD_THIRD),
    FOURTH(GRADE_FOURTH, REWARD_FOURTH)
}