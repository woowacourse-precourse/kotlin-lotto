package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {
    private val user = User()
    @Test
    fun `로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            (user.validateUnitAmount("5500"))
        }
    }

    @Test
    fun `로또 구입 금액에 숫자가 아닌 문자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { (user.validateTypeAmount("1000q")) }
    }
}