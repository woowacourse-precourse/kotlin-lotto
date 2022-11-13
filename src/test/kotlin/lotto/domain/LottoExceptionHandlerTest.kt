package lotto.domain

import lotto.utils.LottoExceptionHandler.validateAmountUnit
import lotto.utils.LottoExceptionHandler.validateIntType
import lotto.utils.LottoExceptionHandler.validateNotNegative
import org.junit.jupiter.api.*

internal class LottoExceptionHandlerTest {
    @Nested
    inner class TypeValidation {
        @DisplayName("입력값이 숫자인 경우")
        @Test
        fun `숫자가 주어지면 예외가 발생하지 않는다`() {
            assertDoesNotThrow {
                validateIntType("1200")
            }
        }

        @DisplayName("입력값이 문자열인 경우")
        @Test
        fun `문자열이 주어지면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                validateIntType("abc")
            }
        }

        @DisplayName("입력값에 문자가 섞여 있는 경우")
        @Test
        fun `문자가 섞여 있으면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                validateIntType("1000c")
            }
        }
    }

    @Nested
    inner class SignValidation {
        @DisplayName("입력값이 양수인 경우")
        @Test
        fun `양수가 주어지면 예외가 발생하지 않는다`() {
            assertDoesNotThrow {
                validateNotNegative(1000)
            }
        }

        @DisplayName("입력값이 음수인 경우")
        @Test
        fun `음수가 주어지면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                validateNotNegative(-1000)
            }
        }

        @DisplayName("입력값이 0인 경우")
        @Test
        fun `0이 주어지면 예외가 발생한다`() {
            assertDoesNotThrow {
                validateNotNegative(0)
            }
        }
    }

    @Nested
    inner class AmountUnitValidation {
        @DisplayName("3000원이 주어진 경우")
        @Test
        fun `1000원 단위로 주어지면 예외가 발생하지 않는다`() {
            assertDoesNotThrow {
                validateAmountUnit(3000)
            }
        }

        @DisplayName("9900원이 주어진 경우")
        @Test
        fun `1000원 단위로 주어지지 않으면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                validateAmountUnit(9900)
            }
        }
    }

}