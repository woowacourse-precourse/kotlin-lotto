package lotto

import lotto.util.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    private val validator = Validator
    @Test
    fun `당첨 번호에 1과 45 사이의 범위에 있지 않은 수가 있다면 예외를 던진다`() {
        val input = listOf("1", "2", "3", "4", "5", "47")
        assertThrows<IllegalArgumentException> {
            validator.isCorrectFormatInputWinningNumber(input)
        }
    }

    @Test
    fun `보너스 번호가 1과 45 사이의 범위에 있지 않다면 예외를 던진다`() {
        val input = "84"
        assertThrows<IllegalArgumentException> {
            validator.isCorrectFormatInputBonusNumber(input)
        }
    }
}