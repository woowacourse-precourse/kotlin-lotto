package lotto

import camp.nextstep.edu.missionutils.Randoms

class MakeLottos {
    private fun getRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    fun getLottos(count: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(count){
            val lotto = getRandomNumber()
            lottos.add(Lotto(lotto))
        }

        return lottos
    }
}