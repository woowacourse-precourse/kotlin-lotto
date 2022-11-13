package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LotteryMachine {

    fun operate(lottoCount: Long): List<Lotto> {
        val lottoTicket = mutableListOf<Lotto>()
        while (lottoTicket.size < lottoCount) {
            lottoTicket.add(Lotto(createRandomLotto()))
        }

        return lottoTicket
    }

    private fun createRandomLotto(): List<Int> {
        var lotto = mutableSetOf<Int>()
        while (lotto.size != 6) {
            lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6).toSet() as MutableSet<Int>
        }

        return lotto.toList().sorted()
    }
}
