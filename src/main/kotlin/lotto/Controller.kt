package lotto

import camp.nextstep.edu.missionutils.Randoms

class Controller {
    private var saveRandomNumber = mutableListOf<List<Int>>()

    fun getLotteryPaper(count: Int) {
        Output.resultPurchase(count)
        repeat(count) {
            val randomNumber = getRandomNumber()
            saveRandomNumber.add(randomNumber)
            println(randomNumber)
        }
        println()
    }

    fun winningStatistics(winningNumber: List<Int>, bonusNumber: Int) {
        saveRandomNumber.forEach {
            var cnt = 0
            for (i in winningNumber.indices) {
                if (it.contains(winningNumber[i])) {
                    cnt++
                }
            }
            if (cnt == 5) {
                if (it.contains(bonusNumber)) {
                    cnt = 7
                }
            }
            resultCorrect(cnt)
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

    private fun resultCorrect(count: Int) {
        when (count) {
            3 -> WinningAmount.FIFTH.number++
            4 -> WinningAmount.FOURTH.number++
            5 -> WinningAmount.THIRD.number++
            6 -> WinningAmount.FIRST.number++
            7 -> WinningAmount.SECOND.number++
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