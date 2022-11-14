package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_MAX_RANGE
import lotto.utils.Constants.LOTTO_MIN_RANGE
import lotto.utils.Constants.LOTTO_NUMBER_COUNT

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

        while (lotto.size != LOTTO_NUMBER_COUNT) {
            lotto = Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_NUMBER_COUNT
            ).toSet() as MutableSet<Int>
        }

        return lotto.toList().sorted()
    }
}
