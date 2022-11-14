package lotto

import camp.nextstep.edu.missionutils.Randoms

class Controller {
    private var three = 0
    private var four = 0
    private var five = 0
    private var fivePlus = 0
    private var six = 0
    private var saveRandomNumber = mutableListOf<List<Int>>()
    private var countNumber = mutableListOf<Int>()

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
            countNumber.add(cnt)
        }
    }

    fun resultCorrect() {
        countNumber.forEach {
            when (it) {
                3 -> three++
                4 -> four++
                5 -> five++
                6 -> six++
                7 -> fivePlus++
            }
        }
    }

    fun resultPrint() {
        Output.winningStatistics()
        printStatistics(WinningAmount.THREE, three)
        printStatistics(WinningAmount.FOUR, four)
        printStatistics(WinningAmount.FIVE, five)
        printStatistics(WinningAmount.FIVE_PLUS, fivePlus)
        printStatistics(WinningAmount.SIX, six)
    }

    fun getYield(amount: Int) {
        val totalWinning = (moneySum()).toDouble()
        val investmentAmount = (amount * 1000).toDouble()
        val resultTotalYield = String.format("%.1f", totalWinning / investmentAmount * 100).toDouble()
        Output.resultYield(resultTotalYield)
    }

    private fun moneySum(): Int {
        return three * 5_000 + four * 50_000 + five * 1_500_000 + fivePlus * 30_000_000 + six * 2_000_000_000
    }
    private fun getRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    private fun printStatistics(w: WinningAmount, number: Int) {
        when (w) {
            WinningAmount.THREE -> Output.resultThree(number)
            WinningAmount.FOUR -> Output.resultFour(number)
            WinningAmount.FIVE -> Output.resultFive(number)
            WinningAmount.FIVE_PLUS -> Output.resultFivePlus(number)
            WinningAmount.SIX -> Output.resultSix(number)
        }
    }
}