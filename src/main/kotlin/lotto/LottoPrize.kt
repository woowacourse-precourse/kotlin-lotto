package lotto

enum class LottoPrize(
    private val matchedCount: Int,
    private val isMatchedLottoNumbers: Boolean = false
) : WinningAmount {

    FIRST_PRIZE(6) {
        override fun winPrize(): Int {
            return 2_000_000_000
        }
    },
    SECOND_PRIZE(5, true) {
        override fun winPrize(): Int {
            return 30_000_000
        }
    },
    THIRD_PRIZE(5) {
        override fun winPrize(): Int {
            return 1_500_000
        }
    },
    FOURTH_PRIZE(4) {
        override fun winPrize(): Int {
            return 50_000
        }
    },
    FIFTH_PRIZE(3) {
        override fun winPrize(): Int {
            return 5_000
        }
    },
    NO_WINNING_AMOUNT(0) {
        override fun winPrize(): Int {
            return 0
        }
    };

    private fun isCorrectMatchingNumberCount(lottoCount: Int, isMatchingNumber: Boolean): Boolean =
        lottoCount == 5 && isMatchingNumber

    private fun isMatchingLottoNumber(lottoMatchingCount: Int, isMatchingBonusNumber: Boolean): Boolean =
        isCorrectMatchingNumberCount(
            lottoMatchingCount,
            isMatchingBonusNumber
        ) == isMatchedLottoNumbers

    companion object {
        fun lottoValueOf(lottoMatchingCount: Int, isMatchingBonusNumber: Boolean): LottoPrize {
            return values()
                .firstOrNull { lottoPrize ->
                    lottoPrize.matchedCount == lottoMatchingCount &&
                            lottoPrize.isMatchingLottoNumber(lottoMatchingCount, isMatchingBonusNumber)
                } ?: NO_WINNING_AMOUNT

        }
    }
}