package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoInputTest {

    @Test
    fun `로또 구입 금액이 숫자가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getInputLottoPriceNotNumericException("Lotto")
        }
    }

    @Test
    fun `로또 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getInputLottoPriceUnitException(4600)
        }
    }


}