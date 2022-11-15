package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `당첨 번호 예외처리 - 6개가 아닌 경우`() {
        var winningLotto = WinningLotto()
        var numbers = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> { winningLotto.validateWinningNumbers(numbers) }
    }

    @Test
    fun `당첨 번호 예외처리 - 중복이 있는 경우`() {
        var winningLotto = WinningLotto()
        var numbers = mutableListOf<Int>(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> { winningLotto.validateWinningNumbers(numbers) }
    }

    @Test
    fun `당첨 번호 예외처리 - 범위를 벗어난 경우`() {
        var winningLotto = WinningLotto()
        var numbers = mutableListOf<Int>(1, 2, 3, 47, 5, 5)
        assertThrows<IllegalArgumentException> { winningLotto.validateWinningNumbers(numbers) }
    }
}