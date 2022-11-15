package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoCreator {
    companion object {
        private fun createRandomLotto(): Lotto {
            var numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            numbers.sort()
            return Lotto(numbers)
        }

        fun createRandomLottos(count: Int): Lottos {
            val lottos = Lottos()
            for (i in 0 until count) {
                lottos.addLotto(createRandomLotto())
            }
            return lottos
        }
    }
}