package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun generateLotto(numberOfLotto: Int): List<List<Int>> {
        val lotto = mutableListOf<List<Int>>()
        for (i in 1..numberOfLotto) {
            val lottoNumber = generateLottoNumber()
            lotto.add(lottoNumber)
        }
        return lotto
    }

    private fun generateLottoNumber(): List<Int> {
        val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lottoNumber.sort()
        return lottoNumber
    }
}