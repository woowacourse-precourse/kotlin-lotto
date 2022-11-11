package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PurchaseTest {

    @Test
    fun `기능 테스트`() {
        val purchase = Purchase(17000)
        Assertions.assertThat(
            purchase.amount == 17000 &&
            purchase.ticket == 17
        )
    }

    @Test
    fun `예외 테스트`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy { Purchase(null) }
    }
}
