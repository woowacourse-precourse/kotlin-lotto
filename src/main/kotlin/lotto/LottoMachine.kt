package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val customerBuyLottoPrice: Int) {

    private val customerBuyLottoCount = this.customerBuyLottoPrice / LottoProcessStatement.LOTTO_UNIT_PRICE

    fun printCustomerBuyLottoCount() {
        println("$customerBuyLottoCount" + LottoProcessStatement.COUNT_LOTTO_BUY + "\n")
    }

    private fun createCustomerLottoNumber(): List<Int>{
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END, LOTTO_NUMBER_SIZE).sorted()
    }

    fun produceLottoNumbers() {
        val totalLottoNumbers = mutableListOf<List<Int>>()
        for (i in 0..customerBuyLottoCount) {
            val lottoNumbers = createCustomerLottoNumber()
            println(lottoNumbers)
            totalLottoNumbers.add(lottoNumbers)
        }
    }



    companion object {
        const val LOTTO_NUMBER_RANGE_START = 1
        const val LOTTO_NUMBER_RANGE_END = 45
        const val LOTTO_NUMBER_SIZE = 6
    }





}