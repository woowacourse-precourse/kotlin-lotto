package domain

import java.lang.Math.round

class EarningRateCalculator(private val purchaseMoney: Int) {
    var earningRate = 0.0

    /**
     * getter 함수
     */
    fun getPurchaseMoney(): Double {
        return this.purchaseMoney.toDouble()
    }

    /**
     * 최종 당첨 금액을 반환하는 함수
     */
    fun getTotalPrice(): Int{
        var totalPrice = 0
        val matches = enumValues<MatchStorage>()
        for (index in matches.indices){
            totalPrice += matches[index].matchPrice * matches[index].matchCount
        }
        return totalPrice
    }

    /**
     * 수익률을 얻고 둘 째 자리에서 반올림해주는 함수
     */
    fun calculateEarningRate() {
        earningRate = getTotalPrice() / getPurchaseMoney() * 100
        earningRate = round(earningRate*10.0)/10.0
    }

    /**
     * 수익률을 출력해주는 함수
     */
    fun showEarningRate(){
        calculateEarningRate()
        println("총 수익률은 ${earningRate}%입니다.")
        println("```")
        println("\n___")
    }

}