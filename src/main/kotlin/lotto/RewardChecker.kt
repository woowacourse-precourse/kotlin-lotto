package lotto

class RewardChecker(private val lottoResult: List<Int>) {

    fun checkRank(): Int {
        val rankResult = mutableListOf<Int>(0, 0, 0, 0, 0)
        for (result in lottoResult) {
            when (result) {
                3 -> rankResult[0] += 1
                4 -> rankResult[1] += 1
                5 -> rankResult[2] += 1
                6 -> rankResult[3] += 1
                7 -> rankResult[4] += 1
            }
        }
        displayRewardResult(rankResult)
        return calculateReward(rankResult)
    }

    private fun displayRewardResult(result: List<Int>) {
        println("3개 일치 (5,000원) - ${result[0]}개")
        println("4개 일치 (50,000원) - ${result[1]}개")
        println("5개 일치 (1,500,000원) - ${result[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[3]}개")
        println("6개 일치 (2,000,000,000원) - ${result[4]}개")
    }

    fun calculateReward(result: List<Int>): Int {
        var reward = 0
        var rewardList = listOf(5000,50000,1500000, 30000000, 2000000000)
        for(i in result.indices){
            reward += rewardList[i]* result[i]
        }
        return reward
    }

}