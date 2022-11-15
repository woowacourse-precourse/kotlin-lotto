package winning

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberCheckerTest {
    @Test
    fun `보너스 번호가 숫자 형식이 아닐 경우 예외 처리한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumberChecker("a", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `보너스 번호가 1~45까지의 숫자가 아닐 경우 예외 처리한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumberChecker("0", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되는 숫자가 있을 경우 예외 처리한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumberChecker("1", listOf(1, 2, 3, 4, 5, 6))
        }
    }

}