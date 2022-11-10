package lotto

enum class LottoResult(val prize: Int) {
    FAIL(0),
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000)
}