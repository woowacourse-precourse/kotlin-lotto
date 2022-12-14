package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoMaker {
    fun generateLotto(count: Int): List<List<Int>> {
        val lottos = mutableListOf<List<Int>>()
        for (i in 0 until count) {
            var lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.add(lotto.sorted())
        }
        return lottos.toList()
    }
}
