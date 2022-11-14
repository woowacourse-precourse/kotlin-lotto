package lotto.domain

class WinningNumber(private val numbers: List<Int>, private val bonusNumber: Int) {

    init {
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.toSet().size == numbers.size)
        require(bonusNumber !in numbers)
    }

    fun winningResult(lotto: Lotto): WinningResult {
        val matchCount = numbers.count { lotto.numbers().contains(it) }
        val matchedBonus = lotto.numbers().contains(bonusNumber)

        return when {
            matchCount == 6 -> WinningResult.FIRST
            matchCount == 5 && matchedBonus -> WinningResult.SECOND
            matchCount == 5 && !matchedBonus -> WinningResult.THIRD
            matchCount == 4 -> WinningResult.FOURTH
            matchCount == 3 -> WinningResult.FIFTH
            else -> WinningResult.NO_LUCK
        }
    }
}