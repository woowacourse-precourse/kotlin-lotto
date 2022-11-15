package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator(private val startInclusive: Int, private val endInclusive: Int, private val n: Int) :
    Generator {
    override fun generateNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, n)
    }
}