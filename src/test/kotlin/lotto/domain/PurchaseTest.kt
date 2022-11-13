package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import java.lang.IllegalArgumentException

class PurchaseTest{
    @Test
    fun `구입 금액이 1000원 단위로 나누어떨어지지 않을 시 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            Purchase().validateMoney(5500)
        }
    }

}