package lotto.domain

import lotto.resources.LOTTO_NUMBER_COUNT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `해당 값들이 잘 나온다`() {
        assertThat(
            LottoRank.of(LOTTO_NUMBER_COUNT, false) == LottoRank.FIRST &&
            LottoRank.of(LOTTO_NUMBER_COUNT - 1, true) == LottoRank.SECOND &&
            LottoRank.of(LOTTO_NUMBER_COUNT - 1, false) == LottoRank.THIRD &&
            LottoRank.of(LOTTO_NUMBER_COUNT - 2, false) == LottoRank.FOURTH &&
            LottoRank.of(LOTTO_NUMBER_COUNT - 3, false) == LottoRank.FIFTH &&
            LottoRank.of(LOTTO_NUMBER_COUNT - 4, false) == LottoRank.NONE
        )
    }
    @Test
    fun `없는 값은 NONE이 나온다`() {
        assertThat(
            LottoRank.of(LOTTO_NUMBER_COUNT, true) == LottoRank.NONE &&
            LottoRank.of(LOTTO_NUMBER_COUNT - 5, true) == LottoRank.NONE
        )
    }
}