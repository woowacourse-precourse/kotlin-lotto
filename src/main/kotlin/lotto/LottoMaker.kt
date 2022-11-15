package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMaker {
    fun createLottoNumbers(): List<Int> {
        val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lottoNumber.sort()
        return lottoNumber
    }
}