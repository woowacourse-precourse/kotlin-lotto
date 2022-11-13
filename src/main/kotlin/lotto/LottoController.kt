package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.roundToLong

class LottoController {

    private var money = Money()
    private var moneyCount: Int = 0
    private val lottoList = mutableListOf<Lotto>()
    private var winningNumber = Lotto(listOf(1,2,3,4,5,6))
    private var bonusNumber = 0
    private val prizeResult = mutableListOf<Int>(0,0,0,0,0,0)
    private var earnedMoney = 0

    fun receiveMoney() {
        this.money = InputView().receiveMoneyInput()
        moneyCount= money.getMoney()/1000
        OutputView().printBuyMessage(moneyCount)
    }

    fun createLotto() {
        for (i in 0 until moneyCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoList.add(Lotto(numbers.sorted()))
        }
        OutputView().printLottoList(lottoList)
    }

    fun receiveWinningNumber(){
        winningNumber = InputView().receiveWinningNumberInput()
    }

    fun receiveBonusNumber(){
        val number = InputView().receiveBonusNumberInput()
        val validator = ValidateInput()
        if (validator.validateNumber(number) && validator.validateRange(number)
            && validator.validateDuplicationBonusNum(winningNumber, number))
            bonusNumber = number.toInt()
    }

    fun result(){
        for (lotto in lottoList){
            val result = lotto.calculateWinningResult(winningNumber, bonusNumber)
            val rank = result.first
            earnedMoney += result.second
            when (rank) {
                Rank.First -> prizeResult[1]++
                Rank.Second -> prizeResult[2]++
                Rank.Third -> prizeResult[3]++
                Rank.Fourth -> prizeResult[4]++
                Rank.Fifth -> prizeResult[5]++
                else -> return
            }
        }

        OutputView().printWinningStatistics(prizeResult)
        val percentage = calculateProfitPercentage(earnedMoney)
        OutputView().printEarningsRate(percentage)
    }
    fun calculateProfitPercentage(totalEarnedMoney: Int): Double {
        val profit = (totalEarnedMoney / money.getMoney().toDouble())*1000
        return (profit.roundToLong().toDouble()/10)
    }

}