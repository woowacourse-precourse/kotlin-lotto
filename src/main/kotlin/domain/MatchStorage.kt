package domain

import utils.Constants

enum class MatchStorage(val matchMessage: String,
                        val matchPrice: Int,
                        var matchCount: Int) {
        MATCH_THREE(Constants.MATCH_THREE_NUMBER_MESSAGE, 5000, 0),
        MATCH_FOUR(Constants.MATCH_FOUR_NUMBER_MESSAGE, 50000, 0),
        MATCH_FIVE(Constants.MATCH_FIVE_NUMBER_MESSAGE, 1500000, 0),
        MATCH_FIVE_WITH_BONUS_NUMBER(Constants.MATCH_FIVE_WITH_BONUS_NUMBER_MESSAGE, 30000000, 0),
        MATCH_SIX(Constants.MATCH_SIX_NUMBER_MESSAGE, 2000000000, 0)
}




