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
}