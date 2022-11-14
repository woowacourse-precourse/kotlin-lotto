package lotto

enum class Reward(val rewardMoney: String, var correctNum: String) {
    FIFTH("5,000","3"),
    Four("50,000","4"),
    Third("1,500,000","5"),
    Second("30,000,000","5 보너스"),
    First("2,000,000,000","6"),
}

class RewardInfo {
    fun resultInit() {
        for (reward in Reward.values()){
            rewardResult[reward] = 0
        }
    }
    companion object {
        var rewardResult = LinkedHashMap<Reward, Int>()
    }
}