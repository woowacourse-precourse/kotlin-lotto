package lotto.domain

class CalculateRateOfReturn() {

    fun calculateRateOfReturn(ranking:List<Int>,price:Int): Double {
        try {
            val rateOfReturnPrice = mutableListOf(CONSTANT.RATEOFRETURN.FIFTH.params,CONSTANT.RATEOFRETURN.FOURTH.params,CONSTANT.RATEOFRETURN.THIRD.params,CONSTANT.RATEOFRETURN.SECOND.params,CONSTANT.RATEOFRETURN.FIRST.params)
            var allRevenuePrice = 0
            for (index in ranking.indices){
                allRevenuePrice += ranking[index] * rateOfReturnPrice[index]
            }
            return ( allRevenuePrice.toDouble() / price.toDouble() ) * 100
        } catch (e: IllegalArgumentException){
            throw e
        }
    }
}