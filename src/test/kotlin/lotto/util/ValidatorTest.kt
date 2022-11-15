package lotto.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.IllegalArgumentException

class ValidatorTest {

    val validator = Validator()

    @Test
    fun `입력값이 null 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkInputNullValidation(null)
        }
    }

    @Test
    fun `입력값이 빈 문자열일 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkInputEmptyValidation("")
        }
    }

    @Test
    fun `입력값을 int로 변환 시 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkStringToIntValidation("1000j")
        }

        assertThrows<IllegalArgumentException> {
            validator.checkStringToIntValidation(",?")
        }
    }

    @Test
    fun `입력된 돈이 양수인지 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkMoneyPositive("-12000")
        }
    }

    @Test
    fun `입력된 돈이 1000으로 나누어지는지 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkMoneyValueValidation("4123")
        }
    }

    @Test
    fun `입력된 당첨 번호가 숫자로만 이루어져있는지 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkWinnigNumberToIntValidation("1?2,3,24??,5?,?,4")
        }
    }

    @Test
    fun `입력된 보너스 번호가 범위에 있는지 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkBonusNumberRangeValidation("0")
        }

        assertThrows<IllegalArgumentException> {
            validator.checkBonusNumberRangeValidation("100")
        }
    }
}