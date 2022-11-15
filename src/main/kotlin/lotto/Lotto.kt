package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        lotteries.add(numbers)
    }

    companion object {
        val lotteries = mutableListOf<List<Int>>()

        fun printLotto() {
            println("${lotteries.size}개를 구매했습니다.")
            for (lottery in lotteries) {
                println(lottery)
            }
        }

        fun createLotto(count: Int) {
            for (c in 1..count) {
                val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
                Lotto(lottoNumber)
            }
        }
    }
}
