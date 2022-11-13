package lotto

import camp.nextstep.edu.missionutils.Randoms

class TicketingMachine {

    fun createLottoNumbers(purchasedLottoCount: Int): List<Lotto> {
        val autoCreatedLottos = mutableListOf<Lotto>()
        while (autoCreatedLottos.size < purchasedLottoCount) {
            autoCreatedLottos.add(createLotto())
        }
        return autoCreatedLottos
    }

    private fun createLotto(): Lotto {
        val randoms: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(randoms.sorted())
    }
}
