package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.resources.LOTTO_END_NUMBER
import lotto.resources.LOTTO_NUMBER_COUNT
import lotto.resources.LOTTO_START_NUMBER

class NumberGenerator {
    fun createRandomNumbers(
        start: Int = LOTTO_START_NUMBER,
        end: Int = LOTTO_END_NUMBER,
        count: Int = LOTTO_NUMBER_COUNT
    ): List<Int> {
        return Randoms.pickUniqueNumbersInRange(start, end, count).sorted()
    }
}
