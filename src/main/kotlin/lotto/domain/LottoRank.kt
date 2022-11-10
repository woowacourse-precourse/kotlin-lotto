package lotto.domain

enum class LottoRank(val matchCnt: Int, val prize: Int) {
    FAIL(-1, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(5, 2000000000)
}