package lotto

import lotto.Units.Companion.FOUR
import lotto.Units.Companion.ONE
import lotto.Units.Companion.REWARD_FIRST
import lotto.Units.Companion.REWARD_FOURTH
import lotto.Units.Companion.REWARD_SECOND
import lotto.Units.Companion.REWARD_THIRD
import lotto.Units.Companion.THREE
import lotto.Units.Companion.TWO

enum class Rank(
    val ranking: Int,
    val reward: Int
) {
    FIRST(ONE, REWARD_FIRST),
    SECOND(TWO, REWARD_SECOND),
    THIRD(THREE, REWARD_THIRD),
    FOURTH(FOUR, REWARD_FOURTH)
}