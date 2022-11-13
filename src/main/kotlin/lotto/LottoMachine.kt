package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {

    fun createRandomLotto(): MutableList<List<Int>> {
        val createdRandomLotto = mutableListOf<Int>()
        while (createdRandomLotto.size < 6) {
            val randomNumber = Randoms.pickNumberInRange(1, 45)
            if (!createdRandomLotto.contains(randomNumber)) {
                createdRandomLotto.add(randomNumber)
            }
        }
        return Lotto(createdRandomLotto).getLottoBundle()
    }
}