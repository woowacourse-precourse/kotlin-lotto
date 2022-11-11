package lotto

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    val lotteries = mutableListOf<Set<Int>>()

    fun makeLotteries(count: Int) {
        while (lotteries.count() != count) {
            makeOneLottery()
        }
    }

    private fun makeOneLottery() {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    private fun checkDuplicateLottery(numbers: Set<Int>) = lotteries.contains(numbers)
}