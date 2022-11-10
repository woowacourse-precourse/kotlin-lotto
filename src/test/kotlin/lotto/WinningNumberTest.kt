package lotto

import lotto.domain.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// TODO: 에러 메시지 프리픽스 검사
@Suppress("NonASCIICharacters")
class WinningNumberTest {
    @Test
    fun `보너스 번호가 1부터 45까지의 수가 아닌 경우 예외를 발생시킨다`() {
        val winNums = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 46
        assertThrows<IllegalArgumentException> {
            WinningNumber(winNums, bonus)
        }
    }

    @Test
    fun `보너스 번호가 로또 번호에 포함되어 있으면 예외를 발생시킨다`() {
        val winNums = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 6
        assertThrows<IllegalArgumentException> {
            WinningNumber(winNums, bonus)
        }
    }
}
