package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    fun createRandomNumbers(
        start: Int = LOTTO_START_NUMBER,
        end: Int = LOTTO_END_NUMBER,
        count: Int = LOTTO_NUMBER_COUNT
    ): List<Int> {
        return Randoms.pickUniqueNumbersInRange(start, end, count).sorted()
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6
    }
}
