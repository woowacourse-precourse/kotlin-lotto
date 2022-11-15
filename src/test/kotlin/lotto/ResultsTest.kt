package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ResultsTest {

    @Test
    fun `당첨 내역 결과 확인`() {
        val results = Results(3)

        val lottos = listOf<Lotto>(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(3, 4, 7, 8, 9, 10))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        results.calculateResult(lottos, winningLotto, bonusNumber)
        Assertions.assertThat(results.prizeMoney).isEqualTo(2030000000.0)
    }

    @Test
    fun `당첨 내역이 없을 때 prizeMoney 확인`() {
        val results = Results(3)

        val lottos = listOf<Lotto>(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(3, 4, 7, 8, 9, 10))
        )
        val winningLotto = Lotto(listOf(11, 12, 13, 14, 15, 16))
        val bonusNumber = 7
        results.calculateResult(lottos, winningLotto, bonusNumber)
        Assertions.assertThat(results.prizeMoney).isEqualTo(0.0)
    }
}