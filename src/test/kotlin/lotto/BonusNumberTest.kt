package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    @Test
    fun `보너스 번호에 Int 값 외의 입력을 받으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("j", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `보너스 번호가 1 ~ 45 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("46", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복 되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("1", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }
}