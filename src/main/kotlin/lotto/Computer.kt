package lotto

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    val lotteries = mutableListOf<List<Int>>()

    fun makeLotteries(count: Int) {
        while (lotteries.count() != count) {
            makeOneLottery()
        }
    }

    private fun makeOneLottery() {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        numbers.sort()
        Lotto(numbers)
        addToList(numbers)
    }

    private fun addToList(numbers: List<Int>) {
        lotteries.add(numbers)
    }
}