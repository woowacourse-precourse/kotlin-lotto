package lotto.domain

private const val LOTTO_SIZE = 6

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            "[ERROR] 로또는 6개의 숫자를 뽑아야만 합니다."
        }
        require(numbers.distinct().size == LOTTO_SIZE) {
            "[ERROR] 로또는 중복된 숫자를 포함하면 안됩니다."
        }
    }

    fun getMatchingCount(
        bonusNumber: Int,
        myLotto: List<List<Int>>
    ): MutableMap<MatchingCount, Int> {
        val matchingCount = mutableMapOf(
            MatchingCount.THREE to 0,
            MatchingCount.THREE to 0,
            MatchingCount.FOUR to 0,
            MatchingCount.FIVE to 0,
            MatchingCount.FIVE_BONUS to 0,
            MatchingCount.SIX to 0
        )

        myLotto.forEach { numbers ->
            val count = getMatchingNumberCount(numbers, bonusNumber)
            matchingCount[count]?.let { value ->
                matchingCount[count] = value + 1
            }
        }

        return matchingCount
    }

    private fun getMatchingNumberCount(myLotto: List<Int>, bonusNumber: Int): MatchingCount {
        val count = myLotto.map { number ->
            numbers.contains(number)
        }.count { it }

        if (count == 5 && myLotto.contains(bonusNumber)) {
            return MatchingCount.FIVE_BONUS
        }

        return when (count) {
            3 -> MatchingCount.THREE
            4 -> MatchingCount.FOUR
            5 -> MatchingCount.FIVE
            6 -> MatchingCount.SIX
            else -> MatchingCount.ETC
        }
    }

    fun getReturnRate(matchingCount: MutableMap<MatchingCount, Int>, price: Int): Double = (
        matchingCount.sum(MatchingCount.THREE) + matchingCount.sum(MatchingCount.FOUR) +
        matchingCount.sum(MatchingCount.FIVE) + matchingCount.sum(MatchingCount.FIVE_BONUS) +
        matchingCount.sum(MatchingCount.SIX)
    ) / price.toDouble()

    private fun MutableMap<MatchingCount, Int>.sum(matchingCount: MatchingCount): Int =
        getOrDefault(matchingCount, 0) * matchingCount.profit
}