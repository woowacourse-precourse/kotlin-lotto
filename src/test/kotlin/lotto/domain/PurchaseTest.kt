package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseTest {

    @Test
    fun `기능 테스트`() {
        val purchase = Purchase(17000)
        assertThat(
            purchase.amount == 17000 &&
            purchase.ticket == 17
        )
    }

    @Test
    fun `예외 테스트`() {
        assertThrows<IllegalArgumentException> { Purchase(null) }
    }
}
