package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.domain.Customer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomerTest {
    @Test
    fun `지불액이 1000원 단위가 아닐 경우, 예외발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Customer().throwPaymentException(5123)
            }
        }
    }
}