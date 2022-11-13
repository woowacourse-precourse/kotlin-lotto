package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest() {
    @Test
    fun `복권 구입 금액 입력 시 복권 구입 개수 확인`() {
        assertThat(Calculator.getLottoCount(4000)).isEqualTo(4)
    }

    @Test
    fun `복권 결과 확인`() {
        assertThat(Calculator.lottoResults.size).isEqualTo(2)
        assertThat(Calculator.lottoResults).containsExactly(LottoResultState.SECOND, LottoResultState.FIFTH)
    }

    @Test
    fun `복권 수익률 확인`() {
        assertThat(Calculator.getYield(5000)).isEqualTo("600100.0")
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun `복권 결과 테스트를 위한 setting`() {
            Calculator.getLottoResult(
                listOf(listOf(1, 2, 3, 4, 5, 6), listOf(4, 5, 7, 8, 9, 10)),
                listOf(1, 2, 3, 4, 5, 7),
                6
            )
        }
    }
}