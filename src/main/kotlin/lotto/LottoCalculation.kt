package lotto

import camp.nextstep.edu.missionutils.Randoms


class LottoCalculation {

    fun generateRandomLotto(generateNumber: Int): List<List<Int>> {
        val lottoList: MutableList<List<Int>> = mutableListOf()

        for (count in 0 until generateNumber) {
            val lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoList.add(lotto)
        }

        return lottoList
    }

}