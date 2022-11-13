package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Model.Lotto
import lotto.Model.Money
import lotto.Model.Rank
import lotto.View.InputView
import lotto.View.OutputView
import kotlin.math.roundToLong

class LottoController {

    private var money = Money()
    private var moneyCount: Int = 0
    private val lottoList = mutableListOf<Lotto>()
    private lateinit var winningNumber: Lotto
    private var bonusNumber = 0
    private val prizeResult = mutableListOf(0, 0, 0, 0, 0, 0)
    private var earnedMoney = 0

    fun receiveMoney() {
        OutputView().printStartMessage()
        this.money = InputView().receiveMoneyInput()
        moneyCount = money.getMoney() / 1000
        OutputView().printBuyMessage(moneyCount)
    }

    fun createLotto() {
        for (i in 0 until moneyCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoList.add(Lotto(numbers.sorted()))
        }
        OutputView().printLottoList(lottoList)
    }

    fun receiveWinningNumber() {
        OutputView().printWinningNumberMessage()
        winningNumber = InputView().receiveWinningNumberInput()
    }

    fun receiveBonusNumber() {
        OutputView().printBonusNumberMessage()
        val bonusNumber = InputView().receiveBonusNumberInput()
        val validator = ValidateInput()
        if (validator.validateDuplicationBonusNum(winningNumber, bonusNumber))
            this.bonusNumber = bonusNumber
    }

    fun concludePrizeResult() {
        for (lotto in lottoList) {
            val result = lotto.calculateWinningResult(winningNumber, bonusNumber)
            val rank = result.first
            earnedMoney += result.second
            when (rank) {
                Rank.First -> prizeResult[1]++
                Rank.Second -> prizeResult[2]++
                Rank.Third -> prizeResult[3]++
                Rank.Fourth -> prizeResult[4]++
                Rank.Fifth -> prizeResult[5]++
                else -> prizeResult[0]++
            }
        }
        OutputView().printWinningStatistics(prizeResult)
    }

    fun concludeEarningRate() {
        val percentage = calculateEarningRate(earnedMoney)
        OutputView().printEarningsRate(percentage)
    }

    private fun calculateEarningRate(totalEarnedMoney: Int): Double {
        val profit = (totalEarnedMoney / money.getMoney().toDouble()) * 1000
        return (profit.roundToLong().toDouble() / 10)
    }
}