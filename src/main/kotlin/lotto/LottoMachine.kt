package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val customerBuyLottoPrice: Int) {

    private val customerBuyLottoCount = this.customerBuyLottoPrice / LottoProcessConstValue.LOTTO_UNIT_PRICE

    fun printCustomerBuyLottoCount() {
        println("$customerBuyLottoCount" + LottoProcessConstValue.COUNT_LOTTO_BUY + "\n")
    }

    private fun createCustomerLottoNumber(): List<Int>{
        return Randoms.pickUniqueNumbersInRange(LottoProcessConstValue.LOTTO_NUMBER_RANGE_START, LottoProcessConstValue.LOTTO_NUMBER_RANGE_END, LottoProcessConstValue.LOTTO_NUMBER_SIZE).sorted()
    }

    fun produceLottoNumbers(): MutableList<List<Int>> {
        val totalLottoNumbers = mutableListOf<List<Int>>()
        for (i in 0..customerBuyLottoCount) {
            val lottoNumbers = createCustomerLottoNumber()
            println(lottoNumbers)
            totalLottoNumbers.add(lottoNumbers)
        }

        return totalLottoNumbers
    }



//    companion object {
//        const val LOTTO_NUMBER_RANGE_START = 1
//        const val LOTTO_NUMBER_RANGE_END = 45
//        const val LOTTO_NUMBER_SIZE = 6
//    }





}