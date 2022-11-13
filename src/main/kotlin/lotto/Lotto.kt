package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {

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

    fun winningStatistics(winningNumber: List<Int>) {
        saveRandomNumber.forEach {
            var cnt = 0
            for (i in winningNumber.indices) {
                if (it.contains(winningNumber[i])) {
                    cnt++
                }
            }
            countNumber.add(cnt)
        }
    }

    private fun getRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}
