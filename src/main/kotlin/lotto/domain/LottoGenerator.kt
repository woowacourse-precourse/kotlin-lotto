package lotto.domain

class LottoGenerator {
    fun createLottoNumber(priceString:String){
        val price = checkPriceInt(priceString)
        checkPriceUnderZero(price)
        checkPriceThousandsUnit(price)
        val lottoCount = getLottoCountValue(price)
    }
    private fun checkPriceInt(price:String): Int {
        try {
            return Integer.parseInt(price)
        } catch (e: IllegalArgumentException){
            println("[ERROR] 로또 구입 금액이 정수가 아닙니다.")
            throw e
        }
    }
    private fun checkPriceUnderZero(price: Int){
        try {
            require(price > MIN_PRICE)
        } catch (e: IllegalArgumentException){
            println("[ERROR] 로또 구입 금액이 0 이하입니다.")
            throw e
        }
    }
    private fun checkPriceThousandsUnit(price: Int){
        try {
            require(price % UNIT == 0)
        } catch (e: IllegalArgumentException){
            println("[ERROR] 로또 구입 금액이 1,000원 단위가 아닙니다.")
            throw e
        }
    }
    fun getLottoCountValue(price: Int): Int {
        return price / UNIT
    }
    companion object {
        const val UNIT = 1000
        const val MIN_PRICE = 0
    }
}