package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream
import java.io.InputStream


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `숫자 외 다른 것을 입력했을 때 예외가 발생한다`() {
        val amount = "가나다"
        val `in`: InputStream = ByteArrayInputStream(amount.toByteArray())
        System.setIn(`in`)
        val assertThrows = assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkNumber()
        }
        assertEquals(assertThrows.message, "[ERROR] 숫자만 입력하세요")
    }

    @Test
    fun `1000으로 나누어 떨어지지 않으면 예외가 발생한다`(){
        val amount = 1500
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkAmount(amount)
        }
    }
}
