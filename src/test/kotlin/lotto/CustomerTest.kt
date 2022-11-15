package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.domain.Customer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomerTest {
    @Test
    fun `지불액이 1000원 단위가 아닐 경우, 예외발생`() {
        val customer = Customer()

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                customer.throwPaymentException("5123")
            }
        }
    }

    @Test
    fun `수익률 계산, 소수점 체크`() {
        val a = 5000
        val b = 8000
        val result = 62.5
        assertThat(Customer().calculateIncome(a, b)).isEqualTo(result)
    }
}