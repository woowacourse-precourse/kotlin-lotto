package lotto

enum class LottoRank(var ticketCount : Int, val winningReward : Int) {
    MATCH_NONE(0, 0),
    MATCH_THREE(0,5000),
    MATCH_FOUR( 0, 50000),
    MATCH_FIVE(0, 1500000),
    MATCH_FIVE_BONUS(0, 30000000),
    MATCH_SIX(0, 2000000000)
}
