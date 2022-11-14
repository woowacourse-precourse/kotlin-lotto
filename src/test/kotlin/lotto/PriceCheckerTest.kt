package lotto

import lotto.domain.PriceChecker
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PriceCheckerTest {

    @Test
    fun `로또 구입 금액이 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PriceChecker("1000j")
        }
    }
    @Test
    fun `로또 구입 금액이 0이하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PriceChecker("0")
        }
    }

    @Test
    fun `로또 구입 금액이 1,000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PriceChecker("1700")
        }
    }
}