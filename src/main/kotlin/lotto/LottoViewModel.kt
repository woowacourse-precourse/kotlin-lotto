package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

class LottoViewModel {
    var issuedNumbers = mutableMapOf<Int, MutableList<Int>>()
    var matchedWinningNumbers = listOf<Int>()
    var matchedBonusNumbers = listOf<Int>()

    fun div(purchaseAmount: String) = purchaseAmount.toInt().div(1000)

    fun compareNumbers(purchaseAmount: String, winningNumber: String, bonusNumber: Int) {
        val winningNumberList = changeToIntList(winningNumber)

        for (i in 0 until div(purchaseAmount)) {
            val unionOfWinning = getMergeList(winningNumberList, issuedNumbers[i])
            matchedWinningNumbers = getMatchedNumbers(unionOfWinning)

            issuedNumbers[i]?.add(bonusNumber)
            matchedBonusNumbers = getMatchedNumbers(issuedNumbers[i]!!.toList())

            calculateWinning()
        }
    }

    fun getProfit(purchaseAmount: String): Double = round(calculateProfit(purchaseAmount) * 10) / 10

    private fun getMergeList(winningNumberList: List<Int>, issuedNumbers: MutableList<Int>?): List<Int> =
        listOf(winningNumberList, issuedNumbers).flatMap { it.orEmpty() }

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

    private fun getWinningAmount(): Double {
        var winningAmount = 0

        Winning.values().forEach {
            winningAmount += it.getAmount()
        }

        return winningAmount.toDouble()
    }

    private fun calculateProfit(purchaseAmount: String): Double = (getWinningAmount() / purchaseAmount.toDouble()) * 100

    companion object{
        fun pickRandomNumber(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

        fun changeToIntList(winningNumber: String): List<Int> = winningNumber.split(",").toList().map { it.toInt() }

        fun getMatchedNumbers(list: List<Int>): List<Int> {
            return list.groupBy { it }
                .filter { it.value.size > 1 }
                .flatMap { it.value }
                .distinct()
        }
    }
}