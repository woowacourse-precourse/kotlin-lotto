package lotto.domain

import java.text.DecimalFormat

import util.Constants

enum class Rating(
    val matches: Int,
    val winningAmount: Int
) {
    SIX(Constants.SIX_MATCH, Constants.FIRST_PRICE),
    FIVE_AND_BONUS(Constants.FIVE_MATCH, Constants.SECOND_PRICE),
    FIVE(Constants.FIVE_MATCH, Constants.THIRD_PRICE),
    FOUR(Constants.FOUR_MATCH, Constants.FORTH_PRICE),
    THREE(Constants.THREE_MATCH, Constants.FIFTH_PRICE),
    NOTHING(Constants.NOTHING_MATCH, Constants.NOTHING_PRICE);

    companion object {
        fun lottoResult(matches: Int, bonusMatch: Boolean): Rating {
            return when (matches) {
                Constants.SIX_MATCH -> SIX
                Constants.FIVE_MATCH -> {
                    if (bonusMatch) FIVE_AND_BONUS else FIVE
                }
                Constants.FOUR_MATCH -> FOUR
                Constants.THREE_MATCH -> THREE
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