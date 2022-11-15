package lotto.domain

import lotto.utils.Constants.LOTTO_PRICE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PublisherTest {

    @Test
    @DisplayName("입력 받은 구입 금액에 맞게 발행할 복권 수를 확인하는 테스트")
    fun `복권_수_확인`() {
        val lottoTicket = publisher.generateLottery(money = Money(PURCHASING_AMOUNT))
        val lottoCount = lottoTicket.first

        Assertions.assertThat(lottoCount).isEqualTo(PURCHASING_AMOUNT / LOTTO_PRICE)
    }

    companion object {
        private val publisher = Publisher()
        private const val PURCHASING_AMOUNT: Long = 30000L
    }
}
