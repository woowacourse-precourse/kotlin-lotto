package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    private var three = 0
    private var four = 0
    private var five = 0
    private var fivePlus = 0
    private var six = 0
    private var saveRandomNumber = mutableListOf<List<Int>>()
    private var countNumber = mutableListOf<Int>()

    init {
        require(numbers.size == 6)
    }

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
