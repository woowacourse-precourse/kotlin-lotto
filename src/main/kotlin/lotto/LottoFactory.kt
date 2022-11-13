package lotto

import lotto.constant.LOTTO_NUM_COUNT
import lotto.constant.LOTTO_NUM_RANGE_END
import kotlin.random.Random

class LottoFactory {

    fun makeLotties(lottoCount: Int): List<List<Int>> {
        return List(lottoCount) { makeLotto() }
    }

    private fun makeLotto(): List<Int> {
        val used = BooleanArray(LOTTO_NUM_RANGE_END + 1)
        val lotto = IntArray(LOTTO_NUM_COUNT)

        for (idx in 0 until LOTTO_NUM_COUNT) {
            var num = getRandomLottoNumber()
            while (used[num]) {
                num = getRandomLottoNumber()
            }
            used[num] = true
            lotto[idx] = num
        }
        return lotto.sorted()
    }

    private fun getRandomLottoNumber(): Int = Random.nextInt(LOTTO_NUM_RANGE_END) + 1
}