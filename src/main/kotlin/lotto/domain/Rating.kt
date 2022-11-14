package lotto.domain

import java.text.DecimalFormat

import util.Constants
import util.Constants.FIFTH_PRICE
import util.Constants.FIRST_PRICE
import util.Constants.FIVE_MATCH
import util.Constants.FORTH_PRICE
import util.Constants.FOUR_MATCH
import util.Constants.NOTHING_MATCH
import util.Constants.NOTHING_PRICE
import util.Constants.SECOND_PRICE
import util.Constants.SIX_MATCH
import util.Constants.THIRD_PRICE
import util.Constants.THREE_MATCH

enum class Rating(
    val matches: Int,
    val winningAmount: Int
) {
    SIX(SIX_MATCH, FIRST_PRICE),
    FIVE_AND_BONUS(FIVE_MATCH, SECOND_PRICE),
    FIVE(FIVE_MATCH, THIRD_PRICE),
    FOUR(FOUR_MATCH, FORTH_PRICE),
    THREE(THREE_MATCH, FIFTH_PRICE),
    NOTHING(NOTHING_MATCH, NOTHING_PRICE);

    companion object {
        fun lottoResult(matches: Int, bonusMatch: Boolean): Rating {
            return when (matches) {
                SIX_MATCH -> SIX
                FIVE_MATCH -> {
                    if (bonusMatch) FIVE_AND_BONUS else FIVE
                }
                FOUR_MATCH -> FOUR
                THREE_MATCH -> THREE
                else -> NOTHING
            }
        }

        // 당첨금액 콤마 표시
        fun Int.convertNumbers(): String {
            val numberFormat = DecimalFormat("#,###")
            return numberFormat.format(this)
        }
    }

}