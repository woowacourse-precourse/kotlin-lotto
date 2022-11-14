package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoCalculation {

//    fun classifyJackpotType(jackpotNumber: List<Int>, lottoList: List<List<Int>>): List<Int> {
//        var count: Int = 0
//
//    }

    fun countDuplicationTwoList(list1: List<Int>, list2: List<Int>): Int {
        var count: Int = 0

        if (list1.find { list2.contains(it) } != null) {
            count++
        }

        return count
    }

    fun generateRandomLotto(generateNumber: Int): List<List<Int>> {
        val lottoList: MutableList<List<Int>> = mutableListOf()

        for (count in 0 until generateNumber) {
            val lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lotto.sort()
            lottoList.add(lotto)
        }

        return lottoList
    }

    fun priceToCount(price: Int): Int {
        return price / 1000
    }

}