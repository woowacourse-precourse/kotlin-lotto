package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


class LottoCalculatorTest {
    @Test
    fun `calculateLottoCountTest`() {
        assertThat(LottoCalculator.calculateLottoCount(80000)).isEqualTo(80)
    }

    @Test
    fun `calculateYieldTest`() {
        val lottos = Lottos()
        lottos.addLotto(Lotto(listOf(8, 21, 23, 41, 42, 43)))
        lottos.addLotto(Lotto(listOf(3, 5, 11, 16, 32, 38)))
        lottos.addLotto(Lotto(listOf(7, 11, 16, 35, 36, 44)))
        lottos.addLotto(Lotto(listOf(1, 8, 11, 31, 41, 42)))
        lottos.addLotto(Lotto(listOf(13, 14, 16, 38, 42, 45)))
        lottos.addLotto(Lotto(listOf(7, 11, 30, 40, 42, 43)))
        lottos.addLotto(Lotto(listOf(2, 13, 22, 32, 38, 45)))
        lottos.addLotto(Lotto(listOf(1, 3, 5, 14, 22, 45)))

        val result = lottos.matchLottos(listOf(1,2,3,4,5,6), 7)
        assertThat(LottoCalculator.calculateYield(8000, result)).isEqualTo(62.5)
    }

}
