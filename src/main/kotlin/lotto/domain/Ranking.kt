package lotto.domain

enum class Ranking(val count: Int, val prize: Int, val matchBonusNumber: Boolean) {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    FAIL(0, 0, false);

    companion object {
        fun getMatchingResult(countOfMatched: Int, matchBonusNumber: Boolean): Ranking {
            return when (val result =
                values().filter { rank -> rank.count == countOfMatched }
                    .firstOrNull() { rank -> rank != SECOND || matchBonusNumber }) {
                null -> FAIL
                else -> result
            }
        }
    }
}