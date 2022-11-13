package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaserTest {

    @Test
    fun `기능 테스트`() {
        val purchaser = Purchaser(17000)
        assertThat(
            purchaser.amount == 17000 &&
            purchaser.ticket == 17
        )
    }

    @Test
    fun `예외 테스트`() {
        assertThrows<IllegalArgumentException> { Purchaser(null) }
    }

    @Test
    fun `수익률 테스트`() {
        val purchaser = Purchaser(5000)
        purchaser.totalPrize = 6200
        assertThat(
            purchaser.rateOfReturn == 6200 / 5000.0F
        )
    }
}
