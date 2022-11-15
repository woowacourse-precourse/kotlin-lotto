package lotto.domain

import java.util.Collections.sort

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBERS_SIZE)
        require(numbers.all { it in LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END })
        require(numbers.toSet().size == numbers.size)
        sort(numbers)
    }

    fun numbers() = numbers

    fun rankWhenWinningNumberIs(winningNumber: WinningNumber): Rank {
        val matchCount = numbers.count { winningNumber.numbers().contains(it) }
        val matchedBonus = numbers.contains(winningNumber.bonusNumber())

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
