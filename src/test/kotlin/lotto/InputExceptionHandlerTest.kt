package lotto

import lotto.domain.InputExceptionHandler
import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputExceptionHandlerTest {
    private val inputExceptionHandler = InputExceptionHandler

    @ParameterizedTest
    @CsvSource(
        PURCHASING_AMOUNT_HAS_REMAINDER,
        PURCHASING_AMOUNT_IS_NOT_NUMBER
    )
    fun `구입 금액 예외처리 테스트`(inputPurchasingAmount: String) {
        assertThrows<IllegalArgumentException> {
            inputExceptionHandler.checkInputPurchasingAmount(inputPurchasingAmount)
        }
    }

    @ParameterizedTest
    @CsvSource(
        WINNING_NUMBERS_IS_NOT_NUMBER,
        WINNING_NUMBERS_HAS_NOT_ELEMENTS,
        WINNING_NUMBERS_IS_NOT_CORRECT_RANGE,
        WINNING_NUMBERS_IS_NOT_UNIQUE,
        delimiter = ' '
    )
    fun `당첨번호 예외처리 테스트`(inputWinningNumbers: String) {
        assertThrows<IllegalArgumentException> {
            inputExceptionHandler.checkInputWinningNumbers(inputWinningNumbers)
        }
    }

    @ParameterizedTest
    @CsvSource(
        BONUS_NUMBER_IS_NOT_NUMBER,
        BONUS_NUMBER_IS_NOT_CORRECT_RANGE,
        BONUS_NUMBER_IS_NOT_UNIQUE
    )
    fun `보너스 번호 예외처리`(inputBonusNumber: String) {
        assertThrows<IllegalArgumentException> {
            inputExceptionHandler.checkInputBonusNumber(TEST_WINNING_NUMBER, inputBonusNumber)
        }
    }

    @Test
    fun `try catch exception println() test`() {
        try {
            inputExceptionHandler.checkInputPurchasingAmount("1000j")
        } catch (e: IllegalArgumentException) {
            println("[ERROR]")
        }
    }

    companion object {
        const val PURCHASING_AMOUNT_HAS_REMAINDER = "14001"
        const val PURCHASING_AMOUNT_IS_NOT_NUMBER = "abcd1"

        const val WINNING_NUMBERS_IS_NOT_NUMBER = "1,2,3,4,5,a"
        const val WINNING_NUMBERS_HAS_NOT_ELEMENTS = "1,2,3,4,5"
        const val WINNING_NUMBERS_IS_NOT_CORRECT_RANGE = "1,2,3,4,5,56"
        const val WINNING_NUMBERS_IS_NOT_UNIQUE = "1,2,3,4,5,5"

        val TEST_WINNING_NUMBER = Lotto(listOf(1, 2, 3, 4, 5, 6))
        const val BONUS_NUMBER_IS_NOT_NUMBER = "a"
        const val BONUS_NUMBER_IS_NOT_CORRECT_RANGE = "50"
        const val BONUS_NUMBER_IS_NOT_UNIQUE = "6"
    }
}