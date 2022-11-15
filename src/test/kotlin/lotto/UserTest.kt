package lotto

import lotto.domain.User
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {
    private val userTest = User()

    @Test
    fun `로또 구입 금액이 숫자인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkAmount("1231a")
        }
    }

    @Test
    fun `로또 구입 금액이 int보다 큰지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkAmount("12311234123124213124")
        }
    }

    @Test
    fun `로또 구입 금액이 1000원으로 나누어 떨어지는지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkAmount("1001")
        }
    }
    @Test
    fun `로또 번호가 숫자인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkPrizeNumber("1,2,3,4,5,a")
        }
    }
}