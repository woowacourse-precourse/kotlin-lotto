package error

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ErrorCheckingTest {
    @Test
    fun `로또 번호가 범위 밖이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ErrorChecking(listOf(1, 2, 3, 4, 5, 50)).checkOutOfRange()
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ErrorChecking(listOf(1, 2, 3, 4, 5, 5)).checkDuplicate()
        }
    }
}