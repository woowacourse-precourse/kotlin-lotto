package lotto

import camp.nextstep.edu.missionutils.Randoms

class Seller {
    fun generateLotto(LottoCnt: Int) {
        val LOTTO_SIZE = 6

        println("\n${LottoCnt}개를 구입했습니다.")
        for (cnt in 0 until LottoCnt) {
            var randLotto = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE).sorted()
            println(randLotto)
        }
    }
}