package lotto

import lotto.domain.LottoGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
}