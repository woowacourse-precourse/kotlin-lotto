package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.resources.LOTTO_END_NUMBER
import lotto.resources.LOTTO_NUMBER_COUNT
import lotto.resources.LOTTO_START_NUMBER

object NumberGenerator {
    fun createRandomNumbers() =
        Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT).sorted()
}
