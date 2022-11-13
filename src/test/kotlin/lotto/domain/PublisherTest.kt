package lotto.domain

import lotto.utils.Constants.LOTTO_PRICE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PublisherTest {

    @DisplayName("발행인은 구입 금액에 맞게 복권을 발행하기")
    @Test
    fun generateLottery() {
        val lottoTicket = publisher.generateLottery(money = Money(PURCHASING_AMOUNT))
        val lottoCount = lottoTicket.size

        Assertions.assertThat(lottoCount).isEqualTo(PURCHASING_AMOUNT.toInt() / LOTTO_PRICE)
    }

    companion object {
        private val publisher = Publisher()
        private const val PURCHASING_AMOUNT = "30000"
    }
}
