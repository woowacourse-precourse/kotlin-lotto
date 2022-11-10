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
            6 -> MatchResult.SIX
            else -> MatchResult.FAILED
        }
    }

    private fun isMatchBonus(bonus: Int): MatchResult =
        if (numbers.contains(bonus)) MatchResult.BONUS else MatchResult.FIVE
}

enum class MatchResult(val index: Int,val money:Int) {
    THREE(0,5000), FOUR(1,50000), FIVE(2,500000), BONUS(3,30000000), SIX(4,2000000000), FAILED(5,0)
}