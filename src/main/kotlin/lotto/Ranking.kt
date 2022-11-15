package lotto

enum class Ranking(val sameNumberCount: Int, val bonusNumberCount: Boolean, val prize: Int) {
    TIER_ONE(6, false, 2000000000),
    TIER_TWO(5, true, 30000000),
    TIER_THREE(5, false, 1500000),
    TIER_FOUR(4, false, 50000),
    TIER_FIVE(3, false, 5000),
    TIER_BLANK(0,false,0);

    companion object {
        fun reverseMap(string: Pair<Int, Boolean>): Ranking =
            Ranking.values().find { it.sameNumberCount == string.first && it.bonusNumberCount == string.second } ?: TIER_BLANK
    }
}