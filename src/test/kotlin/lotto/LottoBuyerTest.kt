package lotto

import lotto.ui.LottoBuyer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoBuyerTest {

    @Test
    fun `로또 구입 금액이 1000원 보다 부족하면 예외처리 한다`() {
        assertThrows<IllegalArgumentException> {
            LottoBuyer().inputLottoPurchasePriceError("900")
        }
    }

    @Test
    fun `로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외처리 한다`() {
        assertThrows<IllegalArgumentException> {
            LottoBuyer().inputLottoPurchasePriceError("1900")
        }
    }

    @Test
    fun `로또 구입 금액이 숫자가 아니면 예외처리 한다`() {
        assertThrows<IllegalArgumentException> {
            LottoBuyer().inputLottoPurchasePriceError("1000asdf")
        }
    }
}