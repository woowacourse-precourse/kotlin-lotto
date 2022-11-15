package lotto


enum class RankAndPrize(val index: Int, val prize: Long) {
    FIRST(0,2000000000),
    SECOND(1,30000000),
    THIRD(2,1500000),
    FOURTH(3,50000),
    FIFTH(4,5000),
    OUTOFRANGE(5,0)
}