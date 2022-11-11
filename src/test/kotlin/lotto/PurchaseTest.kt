package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class PurchaseTest {

    @Test
    fun `로또 구매 금액이 나머지가 존재하면 예외 반환`(){
        assertThrows<IllegalArgumentException> {
            val purchase = Purchase()
            val result = purchase.checkMoney(14501)
            assertThat(true).isEqualTo(result)
        }
    }

    @Test
    fun `로또 구매 금액에 맞는 로또 갯수 존재 여부 테스트`() {
        val purchase = Purchase()
        val result = purchase.updateLottoCount(14000)
        assertThat(14).isEqualTo(result)
    }
}