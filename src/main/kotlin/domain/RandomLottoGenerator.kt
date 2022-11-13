package domain

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoGenerator {

    private val randomLotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_BOUND, LOTTO_MAX_BOUND, LOTTO_SIZE).sorted()

    fun getRandomLotto(): List<Int> = randomLotto

    companion object {
        const val LOTTO_MIN_BOUND = 1
        const val LOTTO_MAX_BOUND = 45
        const val LOTTO_SIZE = 6
    }
}
