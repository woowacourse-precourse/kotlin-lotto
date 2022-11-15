package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {
    @Test
    fun `1000원 단위가 아닌 금액 입력`() {
        assertThrows<IllegalArgumentException> {
            Money("4200")
        }
    }
}