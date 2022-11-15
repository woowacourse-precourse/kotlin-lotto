package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import constant.LOTTO_NUM_COUNT
import constant.LOTTO_NUM_RANGE_END
import constant.LOTTO_NUM_RANGE_START

class LottoFactory {

    fun makeLotties(lottoCount: Int): List<List<Int>> {
        return List(lottoCount) { getSortedRandomLottoNumber() }
    }

    private fun getSortedRandomLottoNumber(): List<Int> = pickUniqueNumbersInRange(
        LOTTO_NUM_RANGE_START,
        LOTTO_NUM_RANGE_END,
        LOTTO_NUM_COUNT
    ).sorted()
}