package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constant.Companion.lottoSize
import lotto.Constant.Companion.maxLottoNumber
import lotto.Constant.Companion.minLottoNumber

class Ticket {
    private fun randomNumber(): MutableList<Int> = Randoms.pickUniqueNumbersInRange(minLottoNumber, maxLottoNumber, lottoSize)

    fun makeLotto(): MutableList<Int> {
        val lottoNumbers = randomNumber()

        lottoNumbers.sort()
        return lottoNumbers
    }
}