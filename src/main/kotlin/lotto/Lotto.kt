package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getMatchingNumber(lottoNumber: List<List<Int>>): MutableList<String> {
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
        if (Seller.bonusNumber.toInt() in randLotto) {
            return "5 보너스"
        }
        return "5"
    }

    fun getWinningLotto() {
        var rewardInfo = RewardInfo()
        var matchingResult = getMatchingNumber(Seller.allRandomRotto)

        rewardInfo.resultInit()

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

    fun showLottoResult() {
        println("\n당첨 통계")
        println("- - -")

        getWinningLotto()
        for (reward in RewardInfo.rewardResult.keys) {
            var rewardCount = RewardInfo.rewardResult[reward]

            if (reward == Reward.Second) {
                var count = reward.correctNum.split(" ")[0]
                println("${count}개 일치, 보너스 볼 일치 (${reward.rewardMoney}원) - ${rewardCount}개")
            } else {
                println("${reward.correctNum}개 일치 (${reward.rewardMoney}원) - ${rewardCount}개")
            }
        }
    }
}
