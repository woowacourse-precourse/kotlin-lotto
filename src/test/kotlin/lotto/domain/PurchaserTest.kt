package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PurchaserTest {
    @Test
    fun `수익률 테스트`() {
        assertThat(
            Purchaser().calculateRateOfReturn(6200, 5000) == 6200 * 10000 / (5000) / 100.0F
        )
    }

    @Test
    fun `순위 테스트`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7))
        )
        assertThat(
            Purchaser().calculateResult(winningLotto, tickets) == listOf(1, 1, 0, 0, 0, 0)
        )
    }
}
