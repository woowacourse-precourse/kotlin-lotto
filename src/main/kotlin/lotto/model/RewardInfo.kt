package lotto.model

enum class Reward(val prize: String) {
    FIFTH("5,000"),
    FOUR("50,000"),
    THIRD("1,500,000"),
    SECOND("30,000,000"),
    FIRST("2,000,000,000"),
}

object RewardInfo {
    val lottoResult = LinkedHashMap<Reward, Int>()

    fun LinkedHashMap<Reward,Int>.init() {
        for (reward in Reward.values()) {
            RewardInfo.lottoResult[reward] = 0
        }
    }

    fun LinkedHashMap<Reward,Int>.add(reward: Reward) {
        lottoResult[reward] = lottoResult[reward]!! + 1
    }
}

