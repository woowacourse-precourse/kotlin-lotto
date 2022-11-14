package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoShop
import lotto.repository.LottoRepository
import lotto.service.dto.LottoDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `LottoService 클래스의` {
    @Nested
    inner class `purchaseLotteries 메소드는` {
        @Nested
        inner class `로또 구입 금액이 주어지면` {
            private val purchaseAmount = 8000
            @Test
            fun `구입 금액에 해당하는 만큼 LottoDto를 받는다`() {
                val lotteries = LottoService.purchaseLotteries(purchaseAmount)

                assertThat(lotteries).hasSize(purchaseAmount / LottoShop.lottoPrice())
                assertThat(lotteries).allMatch { it.javaClass == LottoDto::class.java }
            }
            @Test
            fun `구입한 로또를 모두 LottoRepository에 저장한다`() {
                LottoService.purchaseLotteries(purchaseAmount)

                val findLotteries = LottoRepository.findAll()

                assertThat(findLotteries.size).isEqualTo(purchaseAmount / LottoShop.lottoPrice())
            }
        }
    }
}