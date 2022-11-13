package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `LottoShop 클래스의` {
    @Nested
    inner class `purchaseLotteries 메소드는` {
        @Nested
        inner class `구입 금액이 주어지면` {
            private val purchaseAmount = 8000
            @Test
            fun `구입 금액에 해당하는 만큼 로또를 구매할 수 있다`() {
                val lotteries = LottoShop.purchaseLotteries(purchaseAmount)

                assertThat(lotteries).hasSize(purchaseAmount / LottoShop.lottoPrice())
            }
        }
    }
}