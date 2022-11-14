package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

@Suppress("NonASCIICharacters")
class WinningNumberTest {
    @Test
    fun `보너스 번호가 1부터 45까지의 수가 아닌 경우 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            makeWinningNumber(
                listOf(1, 2, 3, 4, 5, 6), -1
            )
        }
    }

    @Test
    fun `보너스 번호가 1부터 45까지의 수인 경우`() {
        assertDoesNotThrow {
            makeWinningNumber(
                listOf(1, 2, 3, 4, 5, 6), 45
            )
        }
    }

    @Test
    fun `보너스 번호가 로또 번호에 포함되어 있지 않은 경우`() {
        assertDoesNotThrow {
            makeWinningNumber(
                listOf(1, 2, 3, 4, 5, 6), 7
            )
        }
    }

    @Test
    fun `보너스 번호가 로또 번호에 포함되어 있으면 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            makeWinningNumber(
                listOf(1, 2, 3, 4, 5, 6), 6
            )
        }
    }

    companion object {
        fun makeWinningNumber(winNums: List<Int>, bonus: Int) =
            WinningNumber(Lotto(winNums), bonus)
    }
}
