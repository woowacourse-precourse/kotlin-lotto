package lotto.domain.customer

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.domain.Lotto

class Purchaser() {
    private val calculator = Calculator()
    private var paidMoney: Int = 0

    private val _purchasedLotto = mutableListOf<Lotto>()
    val purchasedLotto: List<Lotto> get() = _purchasedLotto

    fun payMoney(inputMoney: String = readLine()): Int {
        paidMoney = MoneyValidator().checkInputValid(inputMoney)
        return paidMoney
    }

    fun receivePurchasedLotteries(lotteries: List<Lotto>) {
        _purchasedLotto.addAll(lotteries)
    }

    fun calculateRank(winningNumbers: List<Int>, bonusNumber: Int): Map<MatchedCount, Int> {
        return calculator.calculateRank(purchasedLotto, winningNumbers, bonusNumber)
    }

    fun calculateEarningRate(): String {
        return calculator.calculateEarningRate(paidMoney)
    }
}
