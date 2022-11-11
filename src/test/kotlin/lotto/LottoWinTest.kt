package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoWinTest {

    @Test
    fun `당첨 번호에 중복된 숫자가 있는 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWin().inputWinningNumberException(listOf("1","2","3","4","5","5"))
        }
    }

    @Test
    fun `당첨 번호와 중복되는 보너스 번호를 입력 받은 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWin().inputWinningBonusNumberException(listOf(1,2,3,4,5,6), 4)
        }
    }
}