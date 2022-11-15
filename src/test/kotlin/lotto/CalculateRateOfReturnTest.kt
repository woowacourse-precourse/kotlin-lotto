package lotto

import lotto.domain.CalculateRateOfReturn
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CalculateRateOfReturnTest {
    @Test
    fun `수익률 계산 기능 확인 테스트`() {
        val result = CalculateRateOfReturn().calculateRateOfReturn(listOf(1,0,0,0,0), 8000)
        Assertions.assertThat(result).isEqualTo(62.5)
    }
}