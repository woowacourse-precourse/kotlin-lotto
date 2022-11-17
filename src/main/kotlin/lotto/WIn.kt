package lotto

enum class Win {
    FIRST_PLACE,
    SECOND_PLACE,
    THIRD_PLACE,
    FOURTH_PLACE,
    FIFTH_PLACE,
    NO_LUCK;

    companion object {
        fun getMyPlace(matchedBall: Int, isMatchedBonusBall: Boolean): Win {
            if (matchedBall == 6 && !isMatchedBonusBall) {
                return FIRST_PLACE
            }
            if (matchedBall == 5 && isMatchedBonusBall) {
                return SECOND_PLACE
            }
            if (matchedBall == 5) {
                return THIRD_PLACE
            }
            if (matchedBall == 4 && !isMatchedBonusBall) {
                return FOURTH_PLACE
            }
            if (matchedBall == 3 && !isMatchedBonusBall) {
                return FIFTH_PLACE
            }
            return NO_LUCK
        }

        fun getIncome(place: Win): Int {
            return when (place) {
                FIRST_PLACE -> 2000000000
                SECOND_PLACE -> 30000000
                THIRD_PLACE -> 1500000
                FOURTH_PLACE -> 50000
                FIFTH_PLACE -> 5000
                NO_LUCK -> 0
            }
        }
    }
}