package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionHandlerTest {
    companion object {
        const val HAS_REMAINDER = "14001"
        const val IS_NOT_NUMBER = "abcd1"
    }

    @Test
    fun `구입 금액 예외처리 - 1000원으로 나누어 떨어지지 않을 때`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkInputPurchasingAmount(Companion.HAS_REMAINDER)
        }
    }

    @Test
    fun `구입 금액 예외처리 - 숫자가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkInputPurchasingAmount(Companion.IS_NOT_NUMBER)
        }
    }
}