package lotto

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
}

const val TWO_THOUS_FIVE_HUND = 2500
const val LOTTO_TEN_QUANTITY = 10
const val TEN_THOUS = 10_000