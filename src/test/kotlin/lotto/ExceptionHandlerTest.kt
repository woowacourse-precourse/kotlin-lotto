package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class ExceptionHandlerTest {
    @Test
    fun `숫자로 이루어져있는지 1000원으로 나누어떨어지는지 예외 확인1`() {
        assertThrows<IllegalArgumentException> {
            val money = "1234"
            ExceptionHandler.checkInputMoney(money)
        }
    }

    @Test
    fun `숫자로 이루어져있는지 1000원으로 나누어떨어지는지 예외 확인2`() {
        assertThrows<IllegalArgumentException> {
            val money = "a123"
            ExceptionHandler.checkInputMoney(money)
        }
    }

    @Test
    fun `숫자로 이루어져있는지 1000원으로 나누어떨어지는지 예외 확인3`() {
        val money = "2000"
        val result = ExceptionHandler.checkInputMoney(money)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `보너스 번호 확인1`() {
        assertThrows<IllegalArgumentException> {
            val numberList = listOf<Int>(1, 2, 3, 4, 5, 6)
            ExceptionHandler.checkBonusNumber("6", numberList)
        }
    }

    @Test
    fun `보너스 번호 확인2`() {
        assertThrows<IllegalArgumentException> {
            val numberList = listOf<Int>(1, 2, 3, 4, 5, 6)
            ExceptionHandler.checkBonusNumber("46", numberList)
        }
    }

    @Test
    fun `보너스 번호 확인3`() {
        val numberList = listOf<Int>(1, 2, 3, 4, 5, 6)
        val result = ExceptionHandler.checkBonusNumber("15", numberList)
        assertThat(result).isEqualTo(true)
    }
}