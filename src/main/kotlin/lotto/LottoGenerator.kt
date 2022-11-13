package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun generateLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(
            MINIMUM_LOTTO_NUMBER,
            MAXIMUM_LOTTO_NUMBER,
            SIZE_OF_LOTTO_NUMBERS))
    }
}