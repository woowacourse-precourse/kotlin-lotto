package lotto.domain

class PriceChecker(priceString:String) {
    init {
        val price = checkPriceInt(priceString)
        checkPriceUnderZero(price)
        checkPriceThousandsUnit(price)
    }
    private fun checkPriceInt(price:String): Int {
        try {
            return Integer.parseInt(price)
        } catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.CHECKPRICEINTERROR.message)
            throw e
        }
    }
    private fun checkPriceUnderZero(price: Int){
        try {
            require(price > CONSTANT.PRICE.MIN_PRICE.params)
        } catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.CHECKPRICEUNDERZEROERROR.message)
            throw e
        }
    }
    private fun checkPriceThousandsUnit(price: Int){
        try {
            require(price % CONSTANT.PRICE.UNIT.params == 0)
        } catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.CHECKPRICETHOUSANDSUNITERROR.message)
            throw e
        }
    }
}

