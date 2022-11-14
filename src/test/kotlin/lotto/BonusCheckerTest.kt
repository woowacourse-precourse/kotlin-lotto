package lotto


import lotto.domain.BonusChecker
import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusCheckerTest {
    @Test
    fun `보너스 숫자가 문자일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusChecker(Lotto(listOf(1, 2, 3, 4, 5, 6)),"a")
        }
    }
    @Test
    fun `보너스 숫자가 1 ~ 45 범위가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusChecker(Lotto(listOf(1, 2, 3, 4, 5, 6)),"47")
        }
    }
    @Test
    fun `보너스 숫자가 당첨 번호와 중복된 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusChecker(Lotto(listOf(1, 2, 3, 4, 5, 6)),"1")
        }
    }


}