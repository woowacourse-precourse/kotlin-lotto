package lotto.domain

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MoneyTest {
    @DisplayName("금액이 5000원인 경우")
    @Test
    fun `금액이 양수이면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            Money(5000)
        }
    }

    @DisplayName("금액이 0원인 경우")
    @Test
    fun `금액이 0원이면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            Money(0)
        }
    }

    @DisplayName("금액이 -1000원인 경우")
    @Test
    fun `금액이 음수이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money(-1000)
        }
    }
}