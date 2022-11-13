package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

class LottoViewModel {
    var issuedNumbers = mutableMapOf<Int, MutableList<Int>>()
    var matchedWinningNumbers = listOf<Int>()
    var matchedBonusNumbers = listOf<Int>()

    fun div(purchaseAmount: String) = purchaseAmount.toInt().div(1000)

    fun pickRandomNumber(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    fun compareNumbers(purchaseAmount: String, winningNumber: String, bonusNumber: Int) {
        val winningNumberList = winningNumber.split(",").toList().map { it.toInt() }

        for (i in 0 until div(purchaseAmount)) {
            val unionOfWinning = listOf(winningNumberList, issuedNumbers[i]).flatMap { it.orEmpty() }
            matchedWinningNumbers = matchedNumbers(unionOfWinning)

            issuedNumbers[i]?.add(bonusNumber)
            matchedBonusNumbers = matchedNumbers(issuedNumbers[i]!!.toList())

            calculateWinning()
        }
    }

    fun getProfit(purchaseAmount: String): Double = round(calculateProfit(purchaseAmount) * 10) / 10

    private fun matchedNumbers(list: List<Int>): List<Int> {
        return list.groupBy { it }
            .filter { it.value.size > 1 }
            .flatMap { it.value }
            .distinct()
    }

    private fun calculateWinning() {
        when (matchedWinningNumbers.size) {
            3 -> { Winning.THREE.calculate() }
            4 -> { Winning.FOUR.calculate() }
            5 -> {
                if (matchedBonusNumbers.size != 1) {
                    Winning.FIVE.calculate()
                } else {
                    Winning.FIVEWITHBONUS.calculate()
                }
            }
            6 -> { Winning.SIX.calculate() }
        }
    }

    private fun getWinningAmount(): Int =
        Winning.THREE.getAmount() +
            Winning.FOUR.getAmount() +
            Winning.FIVE.getAmount() +
            Winning.FIVEWITHBONUS.getAmount() +
            Winning.SIX.getAmount()

    private fun calculateProfit(purchaseAmount: String): Double = (getWinningAmount().toDouble() / purchaseAmount.toDouble()) * 100
}