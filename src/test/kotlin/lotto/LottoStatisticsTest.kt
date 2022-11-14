package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStatisticsTest {

    @Test
    fun `당첨 번호와 로또 번호의 비교 연산`() {
        assertThat(LottoStatistics().matchingCalculator(Client()))
    }
}