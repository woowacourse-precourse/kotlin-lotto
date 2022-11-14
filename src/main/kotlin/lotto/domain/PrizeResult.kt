package lotto.domain

data class PrizeResult(
    var firstPlace: Int = 0,
    var secondPlace: Int = 0,
    var thirdPlace: Int = 0,
    var fourthPlace: Int = 0,
    var fifthPlace: Int = 0,
) {
    fun updatePrizeResult(prize: Prize) {
        when (prize) {
            Prize.FIRST -> firstPlace++
            Prize.SECOND -> secondPlace++
            Prize.THIRD -> thirdPlace++
            Prize.FOURTH -> fourthPlace++
            Prize.FIFTH -> fifthPlace++
        }
    }

    fun getTotalPrizeMoney(): Int {
        return (Prize.FIRST.prizeMoney * firstPlace
        + Prize.SECOND.prizeMoney * secondPlace
        + Prize.THIRD.prizeMoney * thirdPlace
        + Prize.FOURTH.prizeMoney * fourthPlace
        + Prize.FIFTH.prizeMoney * fifthPlace)
    }
}
