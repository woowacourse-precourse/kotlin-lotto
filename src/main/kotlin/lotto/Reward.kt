package lotto

import kotlin.math.round
import lotto.LottoNumber

class Reward {
    val countReward: MutableList<Int> = mutableListOf(0,0,0,0,0)
    var money = 0
    var revenue:Float = 0.0F

    fun calculateSame(lottoNumber: MutableList<MutableList<Int>>, winningNumber:  List<Int>, bonusNumber: Int) {
        for(i:Int in lottoNumber.indices){
            val difference = winningNumber.toSet().minus(lottoNumber[i].toSet())
            val duplicationCount = winningNumber.size - difference.size
            val countWinning = calculateReward(duplicationCount,bonusNumber,lottoNumber[i])
            for(index:Int in 0 until countReward.size){
                countReward[index] = countReward[index] + countWinning[index]
            }
        }
        println(countReward)
        calculateMoney(countReward)
    }

    private fun calculateMoney(countReward: MutableList<Int>) {
        for(index:Int in 0 until countReward.size) {
            when (index) {
                0 -> money += countReward[0] * 5000
                1 -> money += countReward[1] * 50000
                2 -> money += countReward[2] * 1500000
                3 -> money += countReward[3] * 30000000
                4 -> money += countReward[4] * 2000000000
            }
        }
    }

    private fun calculateReward(duplicationCount: Int, bonusNumber:Int, lottoNumber: List<Int>): MutableList<Int> {
        val countReward:MutableList<Int> = mutableListOf(0,0,0,0,0)
        when(duplicationCount){
            3 -> countReward[0]=+1
            4 -> countReward[1]=+1
            5 -> whenCountFive(countReward, bonusNumber, lottoNumber)
            6 -> countReward[4]+=1
        }
        return countReward
    }

    private fun whenCountFive(countReward: MutableList<Int>, bonusNumber: Int, lottoNumber: List<Int>): MutableList<Int> {
        if(lottoNumber.contains(bonusNumber)){
            countReward[3] =+ 1
            return countReward
        }
        countReward[2] =+ 1
        return  countReward
    }

    fun calculateRevenue(money:Int, price:Int) {
        revenue =(money.toFloat()/price.toFloat())*100
        revenue = round(revenue*10) /10
        Output.printReward(countReward,revenue)
    }
}