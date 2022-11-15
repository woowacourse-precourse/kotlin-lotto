package domain

import domain.PurchaseMoney
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseMoneyTest {

    @Test
    fun `구입 금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseMoney(1200)
        }
    }

    @Test
    fun `구입 금액이 0보다 작으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseMoney(-1000)
        }
    }
}