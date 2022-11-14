package lotto.domain

class WinningNumber(private val numbers: List<Int>, private val bonusNumber: Int) {

    init {
        require(numbers.size == LOTTO_NUMBERS_SIZE)
        require(numbers.all { it in LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END })
        require(numbers.toSet().size == numbers.size)
        require(bonusNumber !in numbers)
    }

    fun getRank(lotto: Lotto): Rank {
        val matchCount = numbers.count { lotto.numbers().contains(it) }
        val matchedBonus = lotto.numbers().contains(bonusNumber)

        return when {
            matchCount == 6 -> Rank.FIRST
            matchCount == 5 && matchedBonus -> Rank.SECOND
            matchCount == 5 && !matchedBonus -> Rank.THIRD
            matchCount == 4 -> Rank.FOURTH
            matchCount == 3 -> Rank.FIFTH
            else -> Rank.NO_LUCK
        }
    }
}