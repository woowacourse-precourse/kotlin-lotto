package lotto.view

class OutputView {
    fun requestMoney() {
        println("구입금액을 입력해 주세요.")
    }

    fun printLottos(count: Int, lottos: List<List<Int>>) {
        println("${count}개를 구매했습니다.")
        for(lotto in lottos){
            println(lotto)
        }
    }

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