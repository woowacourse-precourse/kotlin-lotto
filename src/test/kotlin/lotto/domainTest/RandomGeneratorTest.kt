package lotto.domainTest

import lotto.domain.RandomGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomGeneratorTest {
    @Test
    fun `생성된 로또 개수 확인`() {
        val randomGenerator = RandomGenerator()
        val lottos = randomGenerator.createRandomlottos(5000)
        val result = lottos.size
        assertThat(result).isEqualTo(5)
    }
}