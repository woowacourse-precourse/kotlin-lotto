package lotto

import lotto.domain.User
import org.assertj.core.api.Assertions
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
}