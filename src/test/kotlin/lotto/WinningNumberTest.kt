package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {
    @Test
    fun `당첨 번호에 숫자나 , 외의 입력을 받으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumberCheckError("1,2,3,4,5,j").throwWinningNumberFormException()
        }
    }
}