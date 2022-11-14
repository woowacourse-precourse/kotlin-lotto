package lotto.domain

import lotto.Lotto

object Result {

    fun compare(lottoLog: ArrayList<Lotto>, lottoNumber: Lotto, bonusNumber: Int): List<Int> {
        val result = mutableListOf<Int>(0, 0, 0, 0, 0)
        val lottoNumbers = lottoNumber.list().toSet()

        for (i in lottoLog) {
            val purchaseLotto = i.list().toSet()
            val rank = decideRank(lottoNumbers, purchaseLotto, bonusNumber)

            if (rank!=-1) {
                result[rank] += 1
            }
        }

        return result
    }

    private fun decideRank(lottoNumber: Set<Int>, purchaseLotto: Set<Int>, bonusNumber: Int): Int {
        val equalNumbers = eachCompare(lottoNumber, purchaseLotto)
        val number = equalNumbers.size

        if (number==6) {return 0}
        if (number==5 && bonusNumber in purchaseLotto.subtract(equalNumbers)) {return 1}
        if (number==5) {return 2}
        if (number==4) {return 3}
        if (number==3) {return 4}

        return -1
    }

    private fun eachCompare(setA: Set<Int>, setB: Set<Int>): Set<Int> {
        return setA.intersect(setB)
    }

}