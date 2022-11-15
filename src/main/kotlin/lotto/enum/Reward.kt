package lotto.enum

import java.text.DecimalFormat

enum class Reward(val reward: Int) {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000),
    NOTHING(0);

    fun rewardString(): String = DecimalFormat("#,###").format(this.reward)
}