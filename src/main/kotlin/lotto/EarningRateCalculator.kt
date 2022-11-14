package lotto

import kotlin.math.round


class EarningRateCalculator(private val reward: Int, private val spendMoney:Int) {

    fun calculateEarningRate(): Double {
        val earningRate = reward.toDouble()/spendMoney*100
        val fixedRate = round( earningRate*10)/10
        displayEarningRate(fixedRate)
        return fixedRate
    }

    private fun displayEarningRate(rate:Double){
        println("총 수익률은 ${rate}%입니다.")
    }
}