package lotto

enum class Rank(val matchNumbers: Int, val prizeMoney: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NON_RANKED(0,0)
}