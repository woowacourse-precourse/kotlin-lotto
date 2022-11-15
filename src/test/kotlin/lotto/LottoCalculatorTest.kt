package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoCalculatorTest {
    lateinit var lottoCalculator: LottoCalculator

    @BeforeEach
    fun setUp() {
        lottoCalculator =
            LottoCalculator(
                mutableListOf(mutableListOf(1, 2, 3, 4, 5, 6)),
                Lotto(mutableListOf(1, 2, 3, 7, 8, 9)),
                11
            )
    }

    @Test
    fun `5등 테스트`() {
        val result = lottoCalculator.calculateLotto()
        Assertions.assertThat(result).isEqualTo(mutableListOf(0, 0, 0, 0, 1))
    }

    @Test
    fun `로또번호에 보너스 번호 포함 여부 테스트`() {
        assertThrows<IllegalArgumentException> {
            lottoCalculator =
                LottoCalculator(
                    mutableListOf(mutableListOf(1, 2, 3, 4, 5, 6)),
                    Lotto(mutableListOf(1, 2, 3, 7, 8, 9)),
                    9
                )
        }
    }
}