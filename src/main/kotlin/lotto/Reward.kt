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
            print(duplicationCount)
            val countWinning = calculateReward(duplicationCount,bonusNumber,winningNumber)
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
        println(money)
    }

    private fun calculateReward(duplicationCount: Int, bonusNumber:Int, winningNumber: List<Int>): MutableList<Int> {
        val countReward:MutableList<Int> = mutableListOf(0,0,0,0,0)
        when(duplicationCount){
            3 -> countReward[0]=+1
            4 -> countReward[1]=+1
            5 -> whenCountFive(countReward, bonusNumber, winningNumber)
            6 -> countReward[4]+=1
        }
        return countReward
    }

    private fun whenCountFive(countReward: MutableList<Int>, bonusNumber: Int, winningNumber: List<Int>): MutableList<Int> {
        if(winningNumber.contains(bonusNumber)){
            countReward[3] =+ 1
            return countReward
        }
        countReward[2] =+ 1
        return  countReward
    }

    fun calculateRevenue(money:Int, price:Int) {
        revenue =(money.toFloat()/price.toFloat())*100
        revenue = round(revenue*10) /10
        printReward(countReward,revenue)
    }

    fun printReward(countReward: MutableList<Int>, revenue:Float){
        println("3개 일치 (5,000원) - "+ countReward[0] +"개\n" +
                "4개 일치 (50,000원) - "+countReward[1] +"개\n" +
                "5개 일치 (1,500,000원) - "+ countReward[2] +"개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - "+ countReward[3] +"개\n" +
                "6개 일치 (2,000,000,000원) - "+ countReward[4] +"개\n"+
                "총 수익률은 "+revenue+"%입니다.")
    }

}