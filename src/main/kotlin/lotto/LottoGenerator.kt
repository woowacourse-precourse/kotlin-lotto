package lotto

import Util.Constants
import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun generateLotto(numberOfLotto: Int): List<List<Int>> {
        val lotto = mutableListOf<List<Int>>()
        for (i in Constants.ONE.constant..numberOfLotto) {
            val lottoNumber = generateLottoNumber()
            lotto.add(lottoNumber)
        }
        return lotto
    }

    private fun generateLottoNumber(): List<Int> {
        val lottoNumber = Randoms.pickUniqueNumbersInRange(
            Constants.LOTTO_NUMBER_MIN.constant,
            Constants.LOTTO_NUMBER_MAX.constant,
            Constants.NUMBER_OF_LOTTO.constant
        )
        lottoNumber.sort()
        return lottoNumber
    }
}