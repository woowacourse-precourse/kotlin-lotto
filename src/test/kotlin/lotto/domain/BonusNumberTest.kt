package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    @Test
    fun `보너스 번호 예외 처리 - 범위를 벗어난 경우`() {
        val bonusNumber = BonusNumber()
        assertThrows<IllegalArgumentException> { bonusNumber.checkBonusNumber("77") }
    }

    @Test
    fun `보너스 번호 예외 처리 - 당첨 번호와 중복된 경우`() {
        val bonusNumber = BonusNumber()
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            bonusNumber.checkDuplicationWithWinningNumber(
                winningLotto,
                "4"
            )
        }
    }
}