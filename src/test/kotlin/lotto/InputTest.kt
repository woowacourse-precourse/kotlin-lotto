package lotto

import lotto.util.Validator.checkBonusInNumber
import lotto.util.Validator.checkBonusNumber
import lotto.util.Validator.checkMoney
import lotto.util.Validator.checkWinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class InputTest {

    @ValueSource(strings = ["1000j", " ", "abc", "100", "1302"])
    @ParameterizedTest
    fun `금액이 숫자 형태가 아니거나 1000으로 나누어지지 않으면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            checkMoney(input)
        }
    }

    @ValueSource(strings = ["1,2,3,4,5,5", "1,2,3", "1-2-3-4-5-6"])
    @ParameterizedTest
    fun `당첨 번호에 중복이 있거나 6개 숫자가 아니면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            checkWinningNumber(input)
        }
    }

    @ValueSource(strings = ["0,1,2,3,4,5", "1,2,3,4,5,50"])
    @ParameterizedTest
    fun `당첨 번호가 숫자 형태가 아니거나 범위를 벗어나면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            checkWinningNumber(input)
        }
    }

    @ValueSource(strings = ["a", " ", "50", "3a"])
    @ParameterizedTest
    fun `보너스 번호가 숫자 형태가 아니거나 범위를 벗어나면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            checkBonusNumber(input)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호에 있으면 예외 발생`() {
        val winningNumber = listOf(1,2,3,4,5,6)
        assertThrows<IllegalArgumentException> {
            checkBonusInNumber(5, winningNumber)
        }
    }
}