package lotto

import lotto.domain.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {
    private val win = WinningNumber("1,2,3,4,5,6")

    @Test
    fun `로또 당첨 번호에 중복된 수가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { (win.validateDuplication(listOf(1, 2, 3, 4, 5, 5))) }
    }

    @Test
    fun `로또 당첨 번호가 1~45 사이가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { (win.validateRange(listOf(1, 2, 3, 4, 5, 46))) }
    }

    @Test
    fun `로또 당첨 번호의 개수가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { win.validateSize(listOf(1, 2, 3, 4, 5)) }
    }
}