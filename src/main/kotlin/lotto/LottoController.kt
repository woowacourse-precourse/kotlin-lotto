package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Model.Lotto
import lotto.Model.Money
import lotto.View.OutputView
import kotlin.math.roundToLong

class LottoController {
    fun createLotto(money: Money): MutableList<Lotto> {
        val moneyCount = money.getMoney() / 1000
        OutputView().printBuyMessage(moneyCount)

        val lottoList = mutableListOf<Lotto>()
        for (index in 0 until moneyCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoList.add(Lotto(numbers.sorted()))
        }
        OutputView().printLottoList(lottoList)
        return lottoList
    }

    fun concludePrizeResult(lottoList: MutableList<Lotto>, winningNumber: Lotto, bonusNumber: Int): MutableList<Int> {
        var earnedMoney = 0
        val prizeResult = mutableListOf(0, 0, 0, 0, 0, 0)

        for (lotto in lottoList) {
            val rank = lotto.calculateWinningResult(winningNumber, bonusNumber)
            earnedMoney += rank.prizeMoney
            prizeResult[rank.rankNum]++
        }

        prizeResult[0] = earnedMoney
        OutputView().printWinningStatistics(prizeResult)
        return prizeResult
    }

    fun concludeEarningRate(earnedMoney: Int, moneyPut: Double) {
        val percentage = calculateEarningRate(earnedMoney, moneyPut)
        OutputView().printEarningsRate(percentage)
    }

    private fun calculateEarningRate(totalEarnedMoney: Int, moneyPut: Double): Double {
        val profit = (totalEarnedMoney / moneyPut) * 1000
        return (profit.roundToLong().toDouble() / 10)
    }
}