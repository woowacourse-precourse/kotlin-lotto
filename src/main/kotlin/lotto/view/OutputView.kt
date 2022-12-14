package lotto.view

import lotto.model.Reward
import lotto.util.Constant.BONUS_RESULT
import lotto.util.Constant.BUY_COUNT
import lotto.util.Constant.PROFIT
import lotto.util.Constant.REQUEST_BONUS_NUMBER
import lotto.util.Constant.REQUEST_MONEY
import lotto.util.Constant.REQUEST_WINNING_NUMBER
import lotto.util.Constant.RESULT
import lotto.util.Constant.REWARD_RESULT
import lotto.util.Constant.SEPARATOR

class OutputView {
    fun requestMoney() {
        println(REQUEST_MONEY)
    }

    fun printLottos(lottos: List<List<Int>>) {
        println("${lottos.size}${BUY_COUNT}")
        for (lotto in lottos) {
            println(lotto)
        }
    }

    fun requestWinningNumber() {
        println(REQUEST_WINNING_NUMBER)
    }

    fun requestBonusNumber() {
        println(REQUEST_BONUS_NUMBER)
    }

    fun printResultTitle() {
        println(REWARD_RESULT)
        println(SEPARATOR)
    }

    fun printResult(reward: Reward, count: Int) {
        println(RESULT(reward,count))
    }

    fun printBonusResult(reward: Reward, count: Int) {
        println(BONUS_RESULT(reward, count))
    }

    fun printProfit(profit: String) {
        println(PROFIT(profit))
    }
}