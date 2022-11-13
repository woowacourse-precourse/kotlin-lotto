package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.LOTTO_END_NUMBER
import lotto.utils.LOTTO_SIZE
import lotto.utils.LOTTO_START_NUMBER

class LottoStore {
    fun purchase(amount: Money): List<Lotto> {
        val lottos = arrayListOf<Lotto>()
        for (i in 0 until amount.convertLottoCount()) {
            lottos.add(publish())
        }
        return lottos
    }

    private fun publish(): Lotto {
        val uniqueNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE)
            .map { number -> LottoNumber(number) }
            .sortedBy { lottoNumber -> lottoNumber.number }

        return Lotto(uniqueNumbers)
    }
}