package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {

    fun generate(count: Int): List<Lotto> {
        val result = mutableListOf<Lotto>()
        for (i in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            result.add(Lotto(numbers))
        }
        return result
    }
}
