package domain

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoGenerator {

    private val randomLotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_BOUND, LOTTO_MAX_BOUND, LOTTO_SIZE).sorted()

    fun getRandomLotto(): List<Int> = randomLotto

    companion object {
        private const val LOTTO_MIN_BOUND = 1
        private const val LOTTO_MAX_BOUND = 45
        private const val LOTTO_SIZE = 6
    }
}
