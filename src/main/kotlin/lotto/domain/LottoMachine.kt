package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val lottoQuantity: Int) {

    private fun createRandomLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    fun getLottoBundle(): MutableList<List<Int>> {
        val lottoBundle = mutableListOf<List<Int>>()
        for (count in 0 until lottoQuantity) {
            val createRandomLotto = createRandomLotto()
            println(createRandomLotto)
            lottoBundle.add(createRandomLotto)
        }
        return lottoBundle
    }
}