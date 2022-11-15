package lotto

import lotto.domain.InputValidation
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {

    private val inputValidation = InputValidation()

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

    @Test
    fun `입력값을 쉼표로 구분했을 때, 6개가 나오지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkInputSplitWithComma("1,2,3,4.5")
        }
    }

    @Test
    fun `보너스 번호가 1~45에 포함되지 않을 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkBonusNumberRange(46)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복 될 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkWinningNumberContainBonusNumber(listOf(1, 2, 3, 4, 5), 1)
        }
    }
}