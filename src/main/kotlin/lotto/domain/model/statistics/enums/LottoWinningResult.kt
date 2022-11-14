package lotto.domain.model.statistics.enums

enum class LottoWinningResult(val matchNumberCount: Int, val matchType: LottoMatchType, val profit: Int) {
    FIRST(6, LottoMatchType.NORMAL, 2_000_000_000),
    SECOND(5, LottoMatchType.BONUS, 30_000_000),
    THIRD(5, LottoMatchType.NORMAL, 1_500_000),
    FOURTH(4, LottoMatchType.NORMAL, 50_000),
    FIFTH(3, LottoMatchType.NORMAL, 5_000),
    LOSE(0, LottoMatchType.NORMAL, 0)
}