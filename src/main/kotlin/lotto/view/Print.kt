package lotto.view

import lotto.util.Constant.Companion.BONUS_NUMBER
import lotto.util.Constant.Companion.BUY_LOTTO
import lotto.util.Constant.Companion.LOTTO_RESULT
import lotto.util.Constant.Companion.REQUEST_MONEY
import lotto.util.Constant.Companion.SEPERATOR
import lotto.util.Constant.Companion.WINNING_LOTTO

object Print {
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

}