package lotto

import lotto.domain.prize.LottoPrize
import lotto.domain.statistics.Profit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProfitTest {
    @Test
    fun `수익률 계산 테스트`() {
        val prizeCount = mapOf(LottoPrize.FIFTH_PRIZE to 1)
        val money = 8000
        val rate = "62.5"
        val result = Profit(prizeCount, money).calculateRate()
        assertThat(result).isEqualTo(rate)
    }
}