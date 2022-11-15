package lotto.enum

enum class WinningRank(val matches: Int, val bonusMatch: Boolean = false) {
    FIFTH(3) {
        override fun isWinning(matches: Int, bonusMatch: Boolean): Boolean =
            this.matches == matches
    },
    FOURTH(4) {
        override fun isWinning(matches: Int, bonusMatch: Boolean): Boolean =
            this.matches == matches
    },
    THIRD(5, false) {
        override fun isWinning(matches: Int, bonusMatch: Boolean): Boolean =
            this.matches == matches && this.bonusMatch == bonusMatch
    },
    SECOND(5, true) {
        override fun isWinning(matches: Int, bonusMatch: Boolean): Boolean =
            this.matches == matches && this.bonusMatch == bonusMatch
    },
    FIRST(6) {
        override fun isWinning(matches: Int, bonusMatch: Boolean): Boolean =
            this.matches == matches
    },
    NOTHING(0) {
        override fun isWinning(matches: Int, bonusMatch: Boolean): Boolean =
            this.matches == matches
    };

    abstract fun isWinning(matches: Int, bonusMatch: Boolean): Boolean
}