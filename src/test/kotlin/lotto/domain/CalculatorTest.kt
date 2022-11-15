package lotto.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `당첨 결과를 담은 리스트의 값이 정확한지 테스트`() {
        assertThat(
            Calculator().calculateWinnings(
                listOf(
                    Lotto(listOf(8, 21, 23, 41, 42, 43)),
                    Lotto(listOf(3, 5, 11, 16, 32, 38)),
                    Lotto(listOf(6, 5, 4, 3, 2, 9)),
                    Lotto(listOf(4, 3, 2, 1, 7, 5)),
                    Lotto(listOf(6, 5, 4, 3, 2, 1)),
                    Lotto(listOf(1, 3, 5, 14, 22, 45))
                ),
                listOf(1, 2, 3, 4, 5, 6),
                7
            )
        ).isEqualTo(listOf(1, 0, 1, 1, 1))
    }

    @Test
    fun `당첨 결과의 수익률 계산 테스트`() {
        assertSimpleTest {
            assertThat(
                Calculator().calculateWinningRate(
                    listOf(1, 0, 0, 0, 0),
                    8000
                )
            ).isEqualTo(62.5)

            assertThat(
                Calculator().calculateWinningRate(
                    listOf(1, 0, 0, 0, 0),
                    50000
                )
            ).isEqualTo(10.0)
        }
    }

    @Test
    fun `반올림 테스트`() {
        assertSimpleTest {
            assertThat(
                Calculator().roundDecimal(63.4656)
            ).isEqualTo(63.5)
            assertThat(
                Calculator().roundDecimal(63.4321)
            ).isEqualTo(63.4)
            assertThat(
                Calculator().roundDecimal(63.0)
            ).isEqualTo(63.0)
        }
    }
}