package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProfitTest {
    @Test
    fun `수익률 계산 테스트`() {
        val prizeCount = mapOf(5000 to 1)
        val money = 8000
        val rate = "62.5"
        val result = Profit(prizeCount, money).calculateRate()
        assertThat(result).isEqualTo(rate)
    }
}