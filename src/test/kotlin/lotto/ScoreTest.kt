package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScoreTest {
    @Test
    fun `수익률 계산 후 출력`() {
        assertThat(Score().calculateWinningRate(
            mutableListOf<Int>(0, 0, 0, 1, 1, 0, 0, 0), 8000)
        )
            .isEqualTo("${(55000 / 8000.0 * 100)}f".toFloat())
    }

}