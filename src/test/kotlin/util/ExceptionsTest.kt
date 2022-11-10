package util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionsTest {

    @Test
    fun `로또 구입 가격 입력값 1000으로 안떨어지는 입력값`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidInputMoney("1900100")
        }
    }

    @Test
    fun `로또 구입 가격 입력값 숫자가 아닌 다른 값`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidInputMoney("1ㄱ000")
        }
    }

    @Test
    fun `로또 구입 가격 0으로 입력값 시작`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidInputMoney("01000")
        }
    }
}