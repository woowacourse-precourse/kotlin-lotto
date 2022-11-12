package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    fun `금액이 음수인 경우`() {
        val money = "-1000"
        assertThrows<IllegalArgumentException> { Money(money) }
    }

    @Test
    fun `금액이 숫자가 아닌 경우 테스트`() {
        val money = "100a"
        assertThrows<IllegalArgumentException> { Money(money) }
    }
}