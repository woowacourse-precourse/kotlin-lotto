package lotto

import lotto.domain.InputValidation
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {

    val inputValidation= InputValidation()

    @Test
    fun `입력값이 정수가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkInputInteger("십삼")
        }
    }

    @Test
    fun `구매금액이 1000으로 나누어 떨지지지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkAmountMultipleOfThousand(2500)
        }
    }
}