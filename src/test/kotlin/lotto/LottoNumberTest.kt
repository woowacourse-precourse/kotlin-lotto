package lotto

import lotto.domain.lotto.LottoNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `로또 번호가 1부터 45사이의 숫자가 아닌 경우 예외가 발생한다`() {
        val lottoNumber = 46
        assertThrows<IllegalArgumentException> {
            LottoNumber(lottoNumber)
        }
    }
}