package winning

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberCheckerTest {
    @Test
    fun `당첨 번호가 6개가 아닐 경우 예외 처리한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumberChecker(listOf("1", "2", "3", "4", "5", "6", "7"))
        }
    }

    @Test
    fun `당첨 번호가 숫자 형식이 아닐 경우 예외 처리한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumberChecker(listOf("a", "2", "3", "4", "5", "6"))
        }
    }

    @Test
    fun `당첨 번호가 1~45까지의 숫자가 아닐 경우 예외 처리한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumberChecker(listOf("0", "1", "2", "3", "4", "5"))
        }
    }

    @Test
    fun `당첨 번호가 중복되는 숫자가 있을 경우 예외 처리한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumberChecker(listOf("1", "2", "3", "4", "5", "5"))
        }
    }
}