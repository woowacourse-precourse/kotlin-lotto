package lotto

import camp.nextstep.edu.missionutils.Randoms

class Machine {
    val lottos = mutableListOf<List<Int>>()

    fun issueLottos(): List<Int> {
        val lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lottos.add(lotto)
        return lotto
    }
}