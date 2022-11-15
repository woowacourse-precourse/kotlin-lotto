package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val customerBuyLottoPrice: Int) {

    private val customerBuyLottoCount = this.customerBuyLottoPrice / 1000

    fun printCustomerBuyLottoCount() {
        println("$customerBuyLottoCount" + LottoProcessStatement.COUNT_LOTTO_BUY + "\n")
    }

    fun createCustomerLottoNumber(): List<Int>{
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }


}