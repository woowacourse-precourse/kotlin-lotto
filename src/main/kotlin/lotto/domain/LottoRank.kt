package lotto.domain

import lotto.util.toPriceFormatted

enum class LottoRank(val matchCnt: Int, val prize: Int) {
    FAIL(-1, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    override fun toString(): String {
        val formatted = prize.toPriceFormatted()
        if (this == SECOND) {
            return "${matchCnt}개 일치, 보너스 볼 일치 (${formatted}원)"
        }
        return "${matchCnt}개 일치 (${formatted}원)"
    }
}