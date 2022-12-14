package lotto.model

class LottoReward(val count: String) {
    fun matchReward(): Any {
        return when (count) {
            "3" -> Reward.FIFTH
            "4" -> Reward.FOUR
            "5" -> Reward.THIRD
            "5bonus" -> Reward.SECOND
            "6" -> Reward.FIRST
            else -> "NONE"
        }
    }
}