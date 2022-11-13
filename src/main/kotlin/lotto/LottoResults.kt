package lotto

import kotlin.math.round

class LottoResults(private val userInputPrice : Int, private val prizeCountList: List<Int>) {

    fun printPrizeResults() {
        for (i in prizeCountList.indices) {
            when (i) {
                0 -> println(EnumPrize().checkPrizeType(EnumPrizeType.FIFTH, prizeCountList[i]))
                1 -> println(EnumPrize().checkPrizeType(EnumPrizeType.FOURTH, prizeCountList[i]))
                2 -> println(EnumPrize().checkPrizeType(EnumPrizeType.THIRD, prizeCountList[i]))
                3 -> println(EnumPrize().checkPrizeType(EnumPrizeType.SECOND, prizeCountList[i]))
                4 -> println(EnumPrize().checkPrizeType(EnumPrizeType.FIRST, prizeCountList[i]))
            }
        }
        println("총 수익률은 ${calculateRevenuePercent()}%입니다.")
    }

    private fun calculateRevenuePercent(): Float {
        var totalWonPrice = 0
        for (i in prizeCountList.indices) {
            when (i) {
                0 -> totalWonPrice += prizeCountList[i] * EnumPrizeType.FIFTH.price
                1 -> totalWonPrice += prizeCountList[i] * EnumPrizeType.FOURTH.price
                2 -> totalWonPrice += prizeCountList[i] * EnumPrizeType.THIRD.price
                3 -> totalWonPrice += prizeCountList[i] * EnumPrizeType.SECOND.price
                4 -> totalWonPrice += prizeCountList[i] * EnumPrizeType.FIRST.price
            }
        }
        return setFloatRounds(totalWonPrice.toFloat() / userInputPrice.toFloat() * 100)
    }

    private fun setFloatRounds(revenuePercent : Float) : Float {
        return round(revenuePercent * 10) / 10
    }
}