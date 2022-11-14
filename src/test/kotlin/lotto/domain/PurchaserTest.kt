package lotto.domain

import lotto.resources.LOTTO_TICKET_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class PurchaserTest {
    @Test fun `티켓을 잘 구매한다`() {
        assertThat(
            Purchaser.purchase(LOTTO_TICKET_PRICE * 17).size == 17
        )
    }

    @Test fun `잘 못된 값을 입력하면 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            Purchaser.purchase(LOTTO_TICKET_PRICE * -1)
        }
        assertThrows<IllegalArgumentException> {
            Purchaser.purchase(LOTTO_TICKET_PRICE - 1)
        }
    }

    @Test
    fun `수익률 테스트`() {
        assertThat(
            Purchaser.calculateRateOfReturn(6200, 5000) == 6200 * 10000 / (5000) / 100.0F
        )
    }

    @Test
    fun `순위 테스트`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7))
        )
        assertThat(
            Purchaser.calculateResult(winningLotto, tickets) == listOf(1, 1, 0, 0, 0, 0)
        )
    }
}
