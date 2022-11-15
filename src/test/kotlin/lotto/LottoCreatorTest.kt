package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat


class LottoCreatorTest {
    @Test
    fun `createRandomLottos`() {
        val lottos = LottoCreator.createRandomLottos(8)
        assertThat(lottos.lottos.size).isEqualTo(8)
    }
}
