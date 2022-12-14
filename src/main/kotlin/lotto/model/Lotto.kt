package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun countMatchNumber(winningLotto: WinningLotto): String {
        val count = numbers.size - (winningLotto.number - numbers).size
        if (count == 5) {
            if (isBonusCorrect(winningLotto.bonus)) {
                return "5bonus"
            }
        }
        return count.toString()
    }

    fun isBonusCorrect(bonus: Int):Boolean = bonus in numbers

/*    fun getMatchingNumber(lottoNumber: List<List<Int>>): MutableList<String> {
        var matchingResult = mutableListOf<String>()

        for (randLotto in lottoNumber) {
            var matchingNumber = (LOTTO_SIZE - (numbers.minus(randLotto)).size).toString()
            if (matchingNumber == "5") {
                matchingNumber = matchBonusNumber(randLotto)
            }
            matchingResult.add(matchingNumber)
        }
        return matchingResult
    }

    fun matchBonusNumber(randLotto: List<Int>): String {
        if (bonusNumber.toInt() in randLotto) {
            return "5 보너스"
        }
        return "5"
    }

    fun getWinningLotto(matchingResult: MutableList<String>) {
        RewardInfo.resultInit()

        for (result in matchingResult) {
            when (result) {
                "3" -> RewardInfo.rewardResult[Reward.FIFTH] = RewardInfo.rewardResult[Reward.FIFTH]!! + 1
                "4" -> RewardInfo.rewardResult[Reward.Four] = RewardInfo.rewardResult[Reward.Four]!! + 1
                "5" -> RewardInfo.rewardResult[Reward.Third] = RewardInfo.rewardResult[Reward.Third]!! + 1
                "5 보너스" -> RewardInfo.rewardResult[Reward.Second] = RewardInfo.rewardResult[Reward.Second]!! + 1
                "6" -> RewardInfo.rewardResult[Reward.First] = RewardInfo.rewardResult[Reward.First]!! + 1
            }
        }
    }

    fun calcReturnRate(): String {
        var totalReward = getTotalReward().toDouble()
        if (totalReward == 0.0) {
            return "0"
        }

        var useMoney = Buyer.payMoney.toDouble()
        var returnRate = ((totalReward / useMoney) * 100)
        return String.format("%,.1f",returnRate)
    }

    fun getTotalReward(): Int {
        var rewardResult = RewardInfo.rewardResult.filterValues { it > 0 }
        var totalReward = 0
        for (reward in rewardResult) {
            var rewardMoney = reward.key.rewardMoney.split(",").joinToString("").toInt()
            totalReward +=  rewardMoney * reward.value
        }
        return totalReward
    }

    fun produceLottoStats() {
        for (reward in RewardInfo.rewardResult.keys) {
            var rewardCount = RewardInfo.rewardResult[reward]!!
            
            if (reward == Reward.Second) {
                var count = reward.correctNum.split(" ")[0]
                Print.lottoBonusResult(count,reward.rewardMoney,rewardCount)
            }
            Print.lottoResult(reward.correctNum, reward.rewardMoney, rewardCount)
        }
    }*/
}
