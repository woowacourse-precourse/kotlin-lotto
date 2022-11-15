package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoInputTest {

    @Test
    fun `로또 구입 금액이 숫자가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getInputLottoPriceException("Lotto")
        }
    }

}