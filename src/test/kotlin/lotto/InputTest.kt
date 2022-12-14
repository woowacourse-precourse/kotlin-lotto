package lotto

import lotto.util.Validator
import lotto.util.Validator.checkMoney
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class InputTest {

    @ValueSource(strings = ["1000j", " ", "abc"])
    @ParameterizedTest
    fun `로또 구매 금액이 숫자 형태가 아니면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            checkMoney(input)
        }
    }

    @ValueSource(strings = ["100", "1302"])
    @ParameterizedTest
    fun `로또 구매 금액이 1000원으로 나누어 떨어지지 않으면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            checkMoney(input)
        }
    }

}