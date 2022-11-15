package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class RandomGenerator {
    private fun createRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun createRandomLottos(inputMoney: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        val count = inputMoney / 1000
        for (index in 0 until count) {
            val lotto = Lotto(createRandomNumbers())
            lottos.add(lotto)
        }
        return lottos
    }
}