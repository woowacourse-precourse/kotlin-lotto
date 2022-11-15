package lotto.domain

import lotto.utils.ErrorMessage.ERROR_NOT_NUMBERS
import lotto.utils.ErrorMessage.ERROR_REMAINING_MONEY
import lotto.utils.Validator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class MoneyTest {

    @Test
    fun `구입 금액이 숫자가 아닌 문자 값이 들어올 경우`() {
        val input = "123k안"
        assertThatThrownBy {
            Validator.checkNumber(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERROR_NOT_NUMBERS)
    }

    @Test
    fun `문자 앞에 0이 들어온 상태로 입력 받을 경우`() {
        val input = "01000"
        assertThatThrownBy {
            Validator.checkNumber(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERROR_NOT_NUMBERS)
    }

    @Test
    fun `1,000으로 나누었을 시에 나머지가 존재할 경우`() {
        val input = 17777L
        assertThatThrownBy {
            val money = Money(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERROR_REMAINING_MONEY)
    }
}
