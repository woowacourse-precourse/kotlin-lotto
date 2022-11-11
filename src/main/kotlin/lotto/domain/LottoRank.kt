package lotto.domain

enum class LottoRank(val matchCnt: Int, val bonusMatched: Boolean, val prize: Int) {
    FAIL(-1, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);
}
