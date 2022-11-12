package lotto

enum class LottoRank(val value: Int) {
    FIRST(5000),
    SECOND(50000),
    THIRD(1500000),
    FOURTH(30000000),
    FIFTH(2000000000),
    FAIL(0),
}