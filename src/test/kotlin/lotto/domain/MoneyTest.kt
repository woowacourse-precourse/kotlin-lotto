package lotto.domain

import lotto.utils.ErrorMessage
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class MoneyTest {

    @DisplayName("구입 금액이 숫자가 아닌 문자 값이 들어올 경우")
    @Test
    fun inputPurchasingAmountNotNumber() {
        val input = "123k안"
        assertThatThrownBy {
            val money = Money(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.ERROR_NOT_NUMBERS)
    }

    @DisplayName("1,000으로 나누었을 시에 나머지가 존재할 경우")
    @Test
    fun existRemainingMoney() {
        val input = "17777"
        assertThatThrownBy {
            val money = Money(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.ERROR_REMAINING_MONEY)
    }

    @DisplayName("첫 글자가 0이 포함될 경우")
    @Test
    fun existFirstWordZero() {
        val input = "01000"
        assertThatThrownBy {
            val money = Money(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessage.ERROR_EXIST_FIRST_WORD_ZERO)
    }
}
