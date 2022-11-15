package lotto

import lotto.domain.lotto.BonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    @Test
    fun `보너스 번호가 당첨 번호에 포함되는 경우 예외가 발생한다`() {
        val winningNumbers = listOf(2, 3, 4, 5, 6, 7)
        val bonusNumber = 7
        assertThrows<IllegalArgumentException> {
            BonusNumber(winningNumbers, bonusNumber)
        }
    }
}