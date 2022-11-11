package util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionsTest {

    @Test
    fun `로또 구입 가격 입력값 1000으로 안떨어지는 입력값`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidInputMoney("1900100")
        }
    }

    @Test
    fun `로또 구입 가격 입력값 숫자가 아닌 다른 값`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidInputMoney("1ㄱ000")
        }
    }

    @Test
    fun `로또 구입 가격 0으로 입력값 시작`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidInputMoney("01000")
        }
    }

    @Test
    fun `문자가 들어간 당첨번호 예외 확인`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidWinningNumber(listOf("1", "2", "3", "t", "7", "12"))
        }
    }

    @Test
    fun `공백이 들어간 당첨번호 예외 확인`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidWinningNumber(listOf("1", "2", "3", " ", "7", "12"))
        }
    }

    @Test
    fun `1~45를 넘어간 0 포함 당첨번호 예외 확인`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidRangeWinningNumber(listOf(0,1,2,3,4,5))
        }
    }

    @Test
    fun `1~45를 넘어간 46 포함 당첨번호 예외 확인`() {
        assertThrows<IllegalArgumentException> {
            Exceptions.isValidRangeWinningNumber(listOf(46,1,2,3,4,5))
        }
    }
}