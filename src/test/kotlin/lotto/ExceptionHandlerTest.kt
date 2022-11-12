package lotto

import lotto.domain.ExceptionHandler
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionHandlerTest {
    companion object {
        const val PURCHASING_AMOUNT_HAS_REMAINDER = "14001"
        const val PURCHASING_AMOUNT_IS_NOT_NUMBER = "abcd1"

        const val WINNING_NUMBERS_IS_NOT_NUMBER = "1,2,3,4,5,a"
        const val WINNING_NUMBERS_HAS_NOT_ELEMENTS = "1,2,3,4,5"
        const val WINNING_NUMBERS_IS_NOT_CORRECT_RANGE = "1,2,3,4,56,6"
        const val WINNING_NUMBERS_IS_NOT_UNIQUE = "1,2,3,4,5,5"
    }

    @Test
    fun `구입 금액 예외처리 - 1000원으로 나누어 떨어지지 않을 때`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkInputPurchasingAmount(Companion.PURCHASING_AMOUNT_HAS_REMAINDER)
        }
    }

    @Test
    fun `구입 금액 예외처리 - 숫자가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkInputPurchasingAmount(Companion.PURCHASING_AMOUNT_IS_NOT_NUMBER)
        }
    }

    @Test
    fun `당첨번호 예외처리 - 숫자가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkInputWinningNumbers(Companion.WINNING_NUMBERS_IS_NOT_NUMBER)
        }
    }

    @Test
    fun `당첨번호 예외처리 - 요소 수가 6개가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkInputWinningNumbers(Companion.WINNING_NUMBERS_HAS_NOT_ELEMENTS)
        }
    }

    @Test
    fun `당첨번호 예외처리 - 로또 범위 내 숫자가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkInputWinningNumbers(Companion.WINNING_NUMBERS_IS_NOT_CORRECT_RANGE)
        }
    }

    @Test
    fun `당첨번호 예외처리 - 중복이 있을 때`() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandler.checkInputWinningNumbers(Companion.WINNING_NUMBERS_IS_NOT_UNIQUE)
        }
    }
}