package lotto

import lotto.domain.LottoGenerator
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
class LottoGeneratorTest {
    @Test
    fun `로또 구입 금액으로 로또 갯수 구하는 기능 테스트()`() {
        val lottoGenerator = LottoGenerator()
        val result = lottoGenerator.getLottoCountValue(10000)
        assertThat(result).isEqualTo(10)
    }
}