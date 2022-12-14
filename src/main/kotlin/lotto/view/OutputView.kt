package lotto.view

import lotto.model.Reward

class OutputView {
    fun requestMoney() {
        println("구입금액을 입력해 주세요.")
    }

    fun printLottos(lottos: List<List<Int>>) {
        println("${lottos.size}개를 구매했습니다.")
        for (lotto in lottos) {
            println(lotto)
        }
    }

    fun requestWinningNumber() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun requestBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun printResultTitle() {
        println("당첨 통계")
        println("---")
    }
    fun printResult(reward: Reward, count: Int) {
        println("${reward.match}개 일치 (${reward.prize}원) - ${count}개")
    }

    fun printBonusResult(reward: Reward, count: Int) {
        val (match, bonus) = reward.match.split(" ")
        println("${match}개 일치, ${bonus} 볼 일치 (${reward.prize}원) - ${count}개")
    }

    fun printProfit(profit: Float) {
        println("총 수익률은 ${profit}%입니다.")
    }
    /*
        fun printBonusResult(lottoResult: LinkedHashMap<Reward, Int>) {

        }*/
    /*
        fun requestMoney() {
            println(REQUEST_MONEY)
        }

        fun winningLotto(){
            println(WINNING_LOTTO)
        }

        fun bonusNumber() {
            println(BONUS_NUMBER)
        }

        fun resultSentence() {
            println(LOTTO_RESULT)
        }

        fun seperator() {
            println(SEPERATOR)
        }

        fun buyLotto(count: Int) {
            println("${count}${BUY_LOTTO}")
        }

        fun lottoBonusResult(count: String, reward: String, rewardCnt: Int) {
            println("${count}개 일치, 보너스 볼 일치 (${reward}원) - ${rewardCnt}개")
        }

        fun lottoResult(count: String, reward: String, rewardCnt: Int) {
            println("${count}개 일치 (${reward}원) - ${rewardCnt}개")
        }

        fun returnRate(rate: String) {
            println("총 수익률은 ${rate}%입니다.")
        }
    */

}