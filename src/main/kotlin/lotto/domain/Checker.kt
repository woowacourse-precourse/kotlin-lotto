package lotto.domain

class Checker {
    class Bonus(private val winning: Lotto,private val bonusString: String) {
        init{
            checkBonusValidNumber()
            val bonus = bonusString.toInt()
            checkBonusValidRange(bonus)
            checkBonusValidWithWinning(bonus)
        }
        private fun checkBonusValidNumber(){
            try {
                bonusString.toInt()
            }catch (e: IllegalArgumentException){
                println(CONSTANT.ERRORMESSAGE.BONUSNUMBERINTERROR.message)
                throw e
            }
        }
        private fun checkBonusValidRange(bonus:Int){
            try {
                require(bonus in CONSTANT.LOTTO.MIN_LOTTO_NUMBER.params..CONSTANT.LOTTO.MAX_LOTTO_NUMBER.params)
            }catch (e: IllegalArgumentException){
                println(CONSTANT.ERRORMESSAGE.BONUSNUMBERRANGEERROR.message)
                throw e
            }
        }
        private fun checkBonusValidWithWinning(bonus: Int){
            try {
                val winningList = winning.returnLottoNumbers()
                require(!winningList.contains(bonus))
            } catch (e: IllegalArgumentException){
                println(CONSTANT.ERRORMESSAGE.BONUSNUMBERDUPLICATEDERROR.message)
                throw e
            }
        }
    }

    class Price(priceString:String) {
        init {
            val price = checkPriceInt(priceString)
            checkPriceUnderZero(price)
            checkPriceThousandsUnit(price)
        }
        private fun checkPriceInt(price:String): Int {
            try {
                return Integer.parseInt(price)
            } catch (e: IllegalArgumentException){
                println(CONSTANT.ERRORMESSAGE.PRICEINTERROR.message)
                throw e
            }
        }
        private fun checkPriceUnderZero(price: Int){
            try {
                require(price > CONSTANT.PRICE.MIN_PRICE.params)
            } catch (e: IllegalArgumentException){
                println(CONSTANT.ERRORMESSAGE.PRICEUNDERZEROERROR.message)
                throw e
            }
        }
        private fun checkPriceThousandsUnit(price: Int){
            try {
                require(price % CONSTANT.PRICE.UNIT.params == 0)
            } catch (e: IllegalArgumentException){
                println(CONSTANT.ERRORMESSAGE.PRICETHOUSANDSUNITERROR.message)
                throw e
            }
        }
    }
}