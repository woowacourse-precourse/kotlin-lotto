package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoCalculation {

    fun countJackpot(lottoList: List<List<Int>>, jackpotNumber: List<Int>, bonusNumber: Int): List<Int> {
        val countJackpotList: MutableList<Int> = List(6) { 0 }.toMutableList()

        for(lottoListIndex in lottoList.indices) {
            val lottoListElement = lottoList[lottoListIndex]
            val countCoincidence: Int = countDuplicationTwoList(lottoListElement, jackpotNumber)
            val jackpotType = classifyJackpotType(lottoListElement, countCoincidence, bonusNumber)

            if(jackpotType != -1) countJackpotList[jackpotType]++
        }

        return countJackpotList
    }

    private fun classifyJackpotType(lotto: List<Int>, countCoincidence: Int, bonusNumber: Int): Int {
        if (countCoincidence == 5 &&
            lotto.contains(bonusNumber)
        ) {
            return INDEX_FIVE_AND_BONUS_COINCIDENCE
        }

        when (countCoincidence) {
            3 -> return INDEX_THREE_COINCIDENCE
            4 -> return INDEX_FOUR_COINCIDENCE
            5 -> return INDEX_FIVE_COINCIDENCE
            6 -> return INDEX_SIX_COINCIDENCE
        }

        return -1
    }

    private fun countDuplicationTwoList(list1: List<Int>, list2: List<Int>): Int {
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