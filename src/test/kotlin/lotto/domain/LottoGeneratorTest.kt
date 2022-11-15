package lotto.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoGeneratorTest {

    val lottoGenerator = LottoGenerator()

    @Test
    fun `로또 다섯개 생성`() {
        val result = lottoGenerator.generate(5)
        assertThat(result.size).isEqualTo(5)
    }
}