package lotto.domain

class LottoGenerator {
    fun createLottoNumber(price:Int){
        val lottoCount = getLottoCountValue(price)
    }

    fun getLottoCountValue(price: Int): Int {
        return price / UNIT
    }
    companion object {
        const val UNIT = 1000
    }
}