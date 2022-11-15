package lotto.domain

import lotto.utils.ErrorMessage.ERROR_NOT_NUMBERS
import lotto.utils.ErrorMessage.ERROR_REMAINING_MONEY
import lotto.utils.Validator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class MoneyTest {

    @Test
    @DisplayName("구입 금액 입력값이 숫자가 아닌 문자가 들어올 경우 예외 테스트")
    fun `구입금액_문자가_들어올때_예외발생`() {
        val input = "123k안"
        assertThatThrownBy {
            Validator.checkNumber(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERROR_NOT_NUMBERS)
    }

    @Test
    @DisplayName("구입 금액 입력값 앞에 0이 들어 온 상태로 입력 받을 경우 예외 테스트")
    fun `구입금액_문자_앞에_0이_있을때_예외발생`() {
        val input = "01000"
        assertThatThrownBy {
            Validator.checkNumber(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERROR_NOT_NUMBERS)
    }

    @Test
    @DisplayName("구입 금액 입력값이 로또 가격(1,000)으로 나누었을 때 나머지가 존재할 경우 예외 테스트")
    fun `구입금액이_1000_단위가_아닐경우_예외발생`() {
        val input = 17777L
        assertThatThrownBy {
            val money = Money(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERROR_REMAINING_MONEY)
    }
}
