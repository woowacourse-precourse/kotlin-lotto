package lotto

import lotto.domain.LottoGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoGeneratorTest {

    @Test
    fun `로또 구입 금액이 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val lottoGenerator = LottoGenerator()
            lottoGenerator.createLottoNumber("1000j")
        }
    }
    @Test
    fun `로또 구입 금액이 0이하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val lottoGenerator = LottoGenerator()
            lottoGenerator.createLottoNumber("0")
        }
    }

    @Test
    fun `로또 구입 금액이 1,000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val lottoGenerator = LottoGenerator()
            lottoGenerator.createLottoNumber("1700")
        }
    }

    @Test
    fun `로또 구입 금액으로 로또 갯수 구하는 기능 테스트`() {
        val lottoGenerator = LottoGenerator()
        val result = lottoGenerator.getLottoCountValue(1000)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `로또 구입 금액으로 로또 갯수 구하는 기능 테스트2`() {
        val lottoGenerator = LottoGenerator()
        val result = lottoGenerator.getLottoCountValue(10000)
        assertThat(result).isEqualTo(10)
    }
}