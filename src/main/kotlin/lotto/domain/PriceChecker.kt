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
            println(Constant.ErrorMessage.CheckPriceIntError.message)
            throw e
        }
    }
    private fun checkPriceUnderZero(price: Int){
        try {
            require(price > Constant.Price.MIN_PRICE.params)
        } catch (e: IllegalArgumentException){
            println(Constant.ErrorMessage.CheckPriceUnderZeroError.message)
            throw e
        }
    }
    private fun checkPriceThousandsUnit(price: Int){
        try {
            require(price % Constant.Price.UNIT.params == 0)
        } catch (e: IllegalArgumentException){
            println(Constant.ErrorMessage.CheckPriceThousandsUnitError.message)
            throw e
        }
    }
}

