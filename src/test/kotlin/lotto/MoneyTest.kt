package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {
    @Test
    fun `구입 금액에 숫자 외의 입력을 받으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MoneyCheckError("10000j").checkMoneyThrowException()
        }
    }

    @Test
    fun `구입 금액이 1,000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MoneyCheckError("10001").checkMoneyThrowException()
        }
    }
}
