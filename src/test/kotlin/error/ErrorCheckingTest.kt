package error

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ErrorCheckingTest {
    @Test
    fun `로또 번호의 개수가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoError.checkNumOfLotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호가 범위 밖이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoError.checkOutOfRange(listOf(1, 2, 3, 4, 5, 50))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoError.checkDuplicate(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `숫자가 아닌 값이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputError.checkInteger("a")
        }
    }

    @Test
    fun `금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputError.checkValidMoney(1450)
        }
    }
}