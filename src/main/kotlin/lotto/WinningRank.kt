package lotto

enum class WinningRank(
    val matchCount: Int,
    val prizeMoney: Int
) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);
}