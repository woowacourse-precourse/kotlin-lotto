package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `로또 결과 확인 테스트 1`() {
        val winning = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
        val player = listOf(
            Lotto(listOf(1, 2, 3, 8, 9, 20)),
            Lotto(listOf(1, 2, 3, 4, 9, 20)),
            Lotto(listOf(1, 2, 3, 4, 5, 20)),
            Lotto(listOf(1, 2, 3, 7, 5, 6)),
            Lotto(listOf(1, 2, 13, 8, 9, 20)),
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        )
        assertThat(LottoResult().getResult(winning, player)).isEqualTo(
            mapOf("FIRST" to 1, "SECOND" to 1, "THIRD" to 1, "FORTH" to 1, "FIFTH" to 1, "NOTHING" to 1)
        )
    }

    @Test
    fun `로또 결과 확인 테스트 2`() {
        val winning = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
        val player = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 7, 6)),
            Lotto(listOf(1, 7, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 9)),
            Lotto(listOf(1, 2, 13, 8, 9, 20))
        )
        assertThat(LottoResult().getResult(winning, player)).isEqualTo(
            mapOf("FIRST" to 0, "SECOND" to 3, "THIRD" to 1, "FORTH" to 0, "FIFTH" to 0, "NOTHING" to 1)
        )
    }
}