package lotto.data

import java.text.DecimalFormat

enum class LottoRank(
    val rank: Int,
    val hitCount: Int,
    val isBonusHit: Boolean,
    val prize: Long
) {

    FIRST(1, 6, false, 2_000_000_000),
    SECOND(2, 5, true, 30_000_000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),;

    override fun toString(): String = buildString {
        append("${hitCount}개 일치")
        if (isBonusHit) {
            append(", 보너스 볼 일치")
        }
        append(" (${DecimalFormat("#,###").format(prize)}원)")
    }

}