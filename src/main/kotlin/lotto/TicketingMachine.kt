package lotto

import camp.nextstep.edu.missionutils.Randoms

private const val LOTTO_START_NUMBER = 1
private const val LOTTO_END_NUMBER = 45
private const val LOTTO_SIZE = 6

class TicketingMachine {

    fun createLottoNumbers(purchasedLottoCount: Int): List<Lotto> {
        val autoCreatedLottos = mutableListOf<Lotto>()
        while (autoCreatedLottos.size < purchasedLottoCount) {
            autoCreatedLottos.add(createLotto())
        }
        return autoCreatedLottos
    }

    private fun createLotto(): Lotto {
        val randoms: List<Int> = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE)
        return Lotto(randoms.sorted())
    }
}
