package lotto.domain

import java.text.DecimalFormat


class Judgement(
    private val computerNumber: List<Lotto>,
    private val userWinningNumber: Lotto,
    private val userBonusNumber: Int
) {
    private val winningCount: ArrayList<Int> = arrayListOf(0, 0, 0, 0, 0)
    private val winningAmount: List<Int> = listOf(5000, 50000, 1500000, 30000000, 2000000000)
    private var count = 0

    fun calculate(): ArrayList<Int> {
        for (numberLine in computerNumber) {
            for (i in 0 until Lotto.Information.SIZE.number) {
                includeNumber(numberLine.getValues(i))
            }
            if (count == 5) {
                includeBounusNumber(numberLine)
            }
            if (count >= 3) {
                winningAccount()
            }
            count = 0
        }
        return winningCount
    }

    private fun includeNumber(number: Int) {
        if (userWinningNumber.contains(number)) {
            count++
        }
    }

    private fun includeBounusNumber(numberLine: Lotto) {
        if (numberLine.contains(userBonusNumber)) {
            winningCount[3]++
            count = 0
        }
    }

    private fun winningAccount() {
        if (count == 3) {
            winningCount[0]++
        }
        if (count == 4) {
            winningCount[1]++
        }
        if (count == 5) {
            winningCount[2]++
        }
        if (count == 6) {
            winningCount[4]++
        }
    }

    fun statistics(): String {
        val totalPrize =
            (winningAmount[0] * winningCount[0]) + (winningAmount[1] * winningCount[1]) + (winningAmount[2] * winningCount[2]) + (winningAmount[3] * winningCount[3]) + (winningAmount[4] * winningCount[4])
        val amount = computerNumber.size * Lotto.Information.PRICE.number
        val decimal = DecimalFormat("#,##0.0%")
        return decimal.format((totalPrize.toDouble() / amount.toDouble()))
    }
}