package lotto.domain.prize

enum class LottoPrize(
    val matchedCount: Int,
    val winningAmount: Int,
    val isMatchedLottoNumbers: Boolean = false
) {

    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    NO_WINNING_AMOUNT(0, 0);

    private fun isCorrectMatchingNumberCount(lottoCount: Int, isMatchingNumber: Boolean): Boolean =
        lottoCount == 5 && isMatchingNumber

    private fun isMatchingLottoNumber(
        lottoMatchingCount: Int,
        isMatchingBonusNumber: Boolean
    ): Boolean =
        isCorrectMatchingNumberCount(
            lottoMatchingCount,
            isMatchingBonusNumber
        ) == isMatchedLottoNumbers

    companion object {
        fun lottoValueOf(lottoMatchingCount: Int, isMatchingBonusNumber: Boolean): LottoPrize {
            return values()
                .firstOrNull { lottoPrize ->
                    lottoPrize.matchedCount == lottoMatchingCount &&
                            lottoPrize.isMatchingLottoNumber(
                                lottoMatchingCount,
                                isMatchingBonusNumber
                            )
                } ?: NO_WINNING_AMOUNT

        }
    }
}