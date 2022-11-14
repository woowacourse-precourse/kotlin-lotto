package lotto.enum

enum class WinningRank(val matches: Int, val bonusMatch: Boolean) {
    FIFTH(3, false),
    FOURTH(4, false),
    THIRD(5, false),
    SECOND(5, true),
    FIRST(6, false),
    NOTHING(0, false);

    fun isWinning(matches: Int, bonusMatch: Boolean): Boolean =
        this.matches == matches && this.bonusMatch == bonusMatch
}