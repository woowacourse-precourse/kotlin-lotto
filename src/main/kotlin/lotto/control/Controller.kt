package lotto.control

import camp.nextstep.edu.missionutils.Randoms
import lotto.message.Output

class Controller {
    private var saveRandomNumber = mutableListOf<List<Int>>()

    fun getLotteryPaper(count: Int) {
        Output.resultPurchase(count)
        repeat(count) {
            val randomNumber = getRandomNumber().sorted()
            saveRandomNumber.add(randomNumber)
            println(randomNumber)
        }
        println()
    }

    fun winningStatistics(winningNumber: List<Int>, bonusNumber: Int) {
        saveRandomNumber.forEach { saveNumber ->
            val count = matchWinningNumber(saveNumber, winningNumber)
            if (count == 5) {
                includeBonusNumber(saveNumber, bonusNumber)
            } else {
                resultCorrect(count)
            }
        }
    }

    fun resultPrint() {
        Output.winningStatistics()
        Output.resultFifth(WinningAmount.FIFTH.number)
        Output.resultFourth(WinningAmount.FOURTH.number)
        Output.resultThird(WinningAmount.THIRD.number)
        Output.resultSecond(WinningAmount.SECOND.number)
        Output.resultFirst(WinningAmount.FIRST.number)
    }

    fun getYield(amount: Int) {
        val totalWinning = (moneySum()).toDouble()
        val investmentAmount = (amount * 1000).toDouble()
        val resultTotalYield = String.format("%.1f", totalWinning / investmentAmount * 100).toDouble()
        Output.resultYield(resultTotalYield)
    }

    private fun matchWinningNumber(saveNumber: List<Int>, winningNumber: List<Int>): Int {
        var count = 0
        winningNumber.forEach { winning ->
            if (saveNumber.contains(winning)) {
                count++
            }
        }
        return count
    }

    private fun includeBonusNumber(saveNumber: List<Int>, bonusNumber: Int) {
        if (saveNumber.contains(bonusNumber)) {
            WinningAmount.SECOND.number++
        } else {
            WinningAmount.THIRD.number++
        }
    }

    private fun resultCorrect(count: Int) {
        when (count) {
            3 -> WinningAmount.FIFTH.number++
            4 -> WinningAmount.FOURTH.number++
            6 -> WinningAmount.FIRST.number++
        }
    }

    private fun moneySum(): Int {
        return WinningAmount.FIRST.firstIncome() + WinningAmount.SECOND.secondIncome() +
                WinningAmount.THIRD.thirdIncome() + WinningAmount.FOURTH.fourthIncome() + WinningAmount.FIFTH.fifthIncome()
    }

    private fun getRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}