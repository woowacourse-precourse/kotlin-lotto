package lotto.model

enum class Reward(val prize: String, val match: String) {
    FIFTH("5,000", "3"),
    FOUR("50,000", "4"),
    THIRD("1,500,000", "5"),
    SECOND("30,000,000", "5 보너스"),
    FIRST("2,000,000,000", "6"),
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

