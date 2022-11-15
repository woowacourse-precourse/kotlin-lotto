package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun printHowManyLottoBuy(money: Int) {
        var result: Int = money / 1000
        println("${result}개를 구매했습니다.")

        for (i in 1..result) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)

        }
    }
}
