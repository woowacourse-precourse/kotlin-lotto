package lotto


class LottoStatistics {
    private val winningNumbers = mutableListOf<Int>()
    private var bonusNumber: Int = 0
    private val matchingCounts = MutableList<Int>(5) { 0 }
    private val yield: Double = 0.0
    private val rule = Rule()

    fun setWinningNumbers(numbers: List<String>) {
        rule.checkWinningNumbers(numbers)
        for (number in numbers) this.winningNumbers.add(number.toInt())
    }

    fun setBonusNumber(number: Int) {
        rule.checkBonusNumber(winningNumbers, number)
        this.bonusNumber = number
    }

    fun matchingCalculator(lottos: List<Lotto>) {
        for (lotto in lottos) {
            val lottoNumbers = lotto.getNumbers()
            val matchingCount = calculateMatchingCount(lottoNumbers)
            val containsBonusNumber = lottoNumbers.contains(bonusNumber)

            setMatchingCounts(matchingCount, containsBonusNumber)
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

    fun getMatchingCounts(): List<Int> {
        return this.matchingCounts
    }
    fun getYield(): Double {
        return this.yield
    }
}

enum class Matching(val index: Int) {
    THREE(0), FOUR(1), FIVE(2), FIVE_AND_BONUS(3), SIX(4);
}
