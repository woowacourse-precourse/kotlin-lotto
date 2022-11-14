package lotto

import data.LOTTO_TEN_QUANTITY
import data.TEN_THOUS
import data.TWO_THOUS_FIVE_HUND
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class PurchaseTest {
    private val purchase = Purchase()

    @Test
    fun `로또 지불 비용이 나머지가 존재하면 예외 반환`() {
        assertThrows<IllegalArgumentException> {
            val remainder = purchase.checkMoney(TWO_THOUS_FIVE_HUND)
            val hasRemainder = true
            assertThat(hasRemainder).isEqualTo(remainder)
        }
    }

    @Test
    fun `로또 지불 비용에 맞는 로또 갯수 존재 여부 테스트`() {
        val lottoQuantity = purchase.updateLottoQuantity(TEN_THOUS)
        assertThat(LOTTO_TEN_QUANTITY).isEqualTo(lottoQuantity)
    }

/*    @Test
    fun `로또 지불 비용에 잘못된 값을 입력했을 때 예외 반환`() {
        assertThrows<IllegalArgumentException> {
            val invalidMoney = purchase.checkInvalidMoney()
            assertThat(true).isEqualTo(invalidMoney)
        }
    }*/
}