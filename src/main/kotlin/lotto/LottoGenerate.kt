package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerate {

    fun createLottos(count: Int) : List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        for(i in 1..count) {
            lottos.add(Lotto(createLottoNumbers()))
        }
        return lottos
    }

    fun createLottoNumbers() : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()

}