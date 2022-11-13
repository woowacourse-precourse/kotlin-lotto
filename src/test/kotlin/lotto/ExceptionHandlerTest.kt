package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ExceptionHandlerTest {
    @Test
    fun `1000으로 나누어 떨어지지 않는 예외 확인1`() {
        val money = 1001
        val result = ExceptionHandler.isDivideBy1000(money)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `1000으로 나누어 떨어지지 않는 예외 확인2`() {
        val money = 1000
        val result = ExceptionHandler.isDivideBy1000(money)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `숫자로 이루어져있는지 1000원으로 나누어떨어지는지 예외 확인1`() {
        val money = "1234"
        val result = ExceptionHandler.checkInputMoney(money)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `숫자로 이루어져있는지 1000원으로 나누어떨어지는지 예외 확인2`() {
        val money = "a123"
        val result = ExceptionHandler.checkInputMoney(money)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `숫자로 이루어져있는지 1000원으로 나누어떨어지는지 예외 확인3`() {
        val money = "10000"
        val result = ExceptionHandler.checkInputMoney(money)
        assertThat(result).isEqualTo(true)
    }

}