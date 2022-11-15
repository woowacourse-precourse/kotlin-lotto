package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

object LottoFactory {

    fun createRandomLotto(): Lotto =
        Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END, LOTTO_NUMBERS_SIZE))
}