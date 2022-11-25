package lotto

import kotlin.math.round

class LottoResults(private val userInputPrice: Int, private val prizeCountList: List<Int>) {
    fun printPrizeResults() {
        for (i in prizeCountList.indices) {
            when (i) {
                0 -> EnumPrize().checkPrizeType(EnumPrizeType.FIFTH, prizeCountList[i])
                1 -> EnumPrize().checkPrizeType(EnumPrizeType.FOURTH, prizeCountList[i])
                2 -> EnumPrize().checkPrizeType(EnumPrizeType.THIRD, prizeCountList[i])
                3 -> EnumPrize().checkPrizeType(EnumPrizeType.SECOND, prizeCountList[i])
                4 -> EnumPrize().checkPrizeType(EnumPrizeType.FIRST, prizeCountList[i])
            }
        }
        PrintForm().printGainPercent(calculateRevenuePercent())
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

    private fun setFloatRounds(revenuePercent: Float): Float {
        return round(revenuePercent * 10) / 10
    }
}