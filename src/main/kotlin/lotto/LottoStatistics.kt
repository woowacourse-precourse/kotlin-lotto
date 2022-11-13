package lotto

import kotlin.math.round


class LottoStatistics {
    private val winningNumbers = mutableListOf<Int>()
    private var bonusNumber: Int = 0
    private val matchingCounts = MutableList(5) { 0 }
    private var profit: Double = 0.0
    private val rule = Rule()

    fun setWinningNumbers(numbers: List<String>) {
        rule.checkWinningNumbers(numbers)
        for (number in numbers) this.winningNumbers.add(number.toInt())
    }

    fun setBonusNumber(number: Int) {
        rule.checkBonusNumber(winningNumbers, number)
        this.bonusNumber = number
    }

    fun matchingCalculator(client: Client) {
        val lottos = client.lottos
        val purchaseAmount = client.purchaseAmount
        for (lotto in lottos) {
            val lottoNumbers = lotto.getNumbers()
            val matchingCount = calculateMatchingCount(lottoNumbers)
            val containsBonusNumber = lottoNumbers.contains(bonusNumber)

            setMatchingCounts(matchingCount, containsBonusNumber)
            calculateProfit(purchaseAmount)
        }
    }

    private fun calculateMatchingCount(lottoNumbers: List<Int>): Int {
        var count = 0
        for (number in lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++
            }
        }
        return count
    }

    private fun setMatchingCounts(matchingCount: Int, containsBonusNumber: Boolean) {
        when (matchingCount) {
            3 -> matchingCounts[Matching.THREE.index]++
            4 -> matchingCounts[Matching.FOUR.index]++
            5 -> {
                if (containsBonusNumber) matchingCounts[Matching.FIVE_AND_BONUS.index]++
                else matchingCounts[Matching.FIVE.index]++
            }

            6 -> matchingCounts[Matching.SIX.index]++
        }
    }

    // 수익률 공식: 100 + (당첨금 - 구매 금액) / 구매 금액 * 100
    private fun calculateProfit(purchaseAmount: Int) {
        var prizeAmount: Long = 0
        val matching = Matching.values()
        for (i in matchingCounts.indices) {
            prizeAmount += matching[i].prize * matchingCounts[i]
        }

        profit = 100 + (prizeAmount - purchaseAmount) / purchaseAmount * 100.0
        profit = round(profit * 10) / 10
    }

    fun getMatchingCounts(): List<Int> {
        return this.matchingCounts
    }

    fun getProfit(): Double {
        return this.profit
    }
}

