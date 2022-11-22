package user

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class MoneyTest {
    @Test
    fun `구입 금액이 숫자 형식이 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money("1000j")
        }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money("1500")
        }
    }
}