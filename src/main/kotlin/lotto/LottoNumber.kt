package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoNumber() {
    val lottoNumber: MutableList<MutableList<Int>> = mutableListOf()
    var lottoCount = 0

    fun calculatePrice(price: Int) {
        if (price % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매 가능합니다.")
        }
        lottoCount = price/1000
        pickNumber(lottoCount)
    }

    private fun pickNumber(lottoCount: Int) {
        for(number:Int in 0 until lottoCount){
            val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            randomNumbers.sort()
            lottoNumber.add(randomNumbers)
        }
        Output.printNumbers(lottoNumber, lottoCount)
    }
}