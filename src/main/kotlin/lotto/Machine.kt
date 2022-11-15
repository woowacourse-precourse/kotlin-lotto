package lotto

import camp.nextstep.edu.missionutils.Randoms

class Machine {
    val lottos = mutableListOf<List<Int>>()

    fun issueLottos(): List<Int> {
        val lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        lottos.add(lotto)
        return lotto
    }

    fun winningsRate(money: Int, profit: Int) = (profit.toFloat() / money.toFloat()) * 100


}