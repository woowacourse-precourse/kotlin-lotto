package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val customerBuyLottoCount: Int) {
    fun printCustomerBuyLottoCount() {
        println("${customerBuyLottoCount / 1000}" + LottoProcessStatement.COUNT_LOTTO_BUY + "\n")
    }

    fun createCustomerLottoNumber(): List<Int>{
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

}