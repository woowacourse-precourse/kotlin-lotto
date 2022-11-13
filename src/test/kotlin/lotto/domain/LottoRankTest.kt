package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `기능 테스트`() {
        assertThat(
            LottoRank.of(6, false) == LottoRank.FIRST &&
            LottoRank.of(5, true) == LottoRank.SECOND &&
            LottoRank.of(5, false) == LottoRank.THIRD &&
            LottoRank.of(4, false) == LottoRank.FOURTH &&
            LottoRank.of(3, false) == LottoRank.FIFTH &&
            LottoRank.of(2, false) == LottoRank.NONE &&
            LottoRank.of(3, true) == LottoRank.NONE
        )
    }
}