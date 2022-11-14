package lotto

import lotto.domain.LottoGenerator
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow

class LottoGeneratorTest {
    @Test
    fun `로또 구입 금액으로 로또 개수 구하는 기능 테스트()`() {
        val lottoGenerator = LottoGenerator()
        val result = lottoGenerator.getLottoCountValue(10000)
        assertThat(result).isEqualTo(10)
    }
    @Test
    fun `로또 번호 구하는 기능 테스트()`(){
        val lottoGenerator = LottoGenerator()
        assertDoesNotThrow { lottoGenerator.getLottoNumber() }
    }

    @Test
    fun `로또 개수에 따른 로또 번호 집단을 구하는 기능 테스트()`(){
        val count = 8
        val lottoGenerator = LottoGenerator()
        val result = lottoGenerator.createLottoNumber(count)
        assertThat(result.distinct().size).isEqualTo(count)
    }
}