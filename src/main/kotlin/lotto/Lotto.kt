package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun matchResult(winning: List<Int>, bonus: Int): MatchResult {
        var count = 0
        numbers.forEach { if (winning.contains(it)) count++ }
        return when (count) {
            3 -> MatchResult.THREE
            4 -> MatchResult.FOUR
            5 -> isMatchBonus(bonus)
            else -> MatchResult.SIX
        }
    }

    private fun isMatchBonus(bonus: Int): MatchResult =
        if (numbers.contains(bonus)) MatchResult.BONUS else MatchResult.FIVE
}

enum class MatchResult {
    THREE, FOUR, FIVE, BONUS, SIX, UNKNOWN
}