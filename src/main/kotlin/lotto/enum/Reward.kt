package lotto.enum

import java.text.DecimalFormat

enum class Reward(private val reward: Int) {
    FIFTH_REWARD(5_000),
    FOURTH_REWARD(50_000),
    THIRD_REWARD(1_500_000),
    SECOND_REWARD(30_000_000),
    FIRST_REWARD(2_000_000_000);

    fun rewardString(): String = DecimalFormat("#,###").format(this.reward)
}