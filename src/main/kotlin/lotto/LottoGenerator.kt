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
        val lottoNumber = mutableListOf<Int>()
        while (lottoNumber.size < 6) {
            val randomNumber = Randoms.pickNumberInRange(1, 45)
            if (!lottoNumber.contains(randomNumber)) {
                lottoNumber.add(randomNumber)
            }
        }
        lottoNumber.sort()
        return lottoNumber
    }
}