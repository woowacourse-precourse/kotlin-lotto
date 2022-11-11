package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    fun createRandomNumbers(
        start: Int = START,
        end: Int = END,
        count: Int = COUNT
    ): List<Int> {
        return Randoms.pickUniqueNumbersInRange(start, end, count).sorted()
    }

    companion object {
        private const val START = 1
        private const val END = 45
        private const val COUNT = 6
    }
}
