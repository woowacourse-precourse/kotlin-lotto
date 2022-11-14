package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `LottoShop 클래스의` {
    @Nested
    inner class `purchaseLotteries 메소드는` {
        @Nested
        inner class `구입 금액이 1000으로 나누어 떨어지지 않으면` {
            private val purchaseAmount = 8001

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { LottoShop.purchaseLotteries(purchaseAmount) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

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