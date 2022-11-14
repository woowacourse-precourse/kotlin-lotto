package lotto.exception

import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    @Test
    fun `구매 금액이 숫자가 아닐 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkMoneyInput("5000j")
        }
    }

    @Test
    fun `구매 금액이 천원 단위가 아닐 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkMoneyInput("5500")
        }
    }

    @Test
    fun `당첨 번호를 콤마로 구분하지 않았을 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkWinningNumberInput("1 2 3 4 5 6")
        }
    }

    @Test
    fun `당첨 번호가 여섯 개가 아닐 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkWinningNumberInput("1, 2, 3, 4, 5, 6, 7")
        }
    }

    @Test
    fun `당첨 번호가 숫자가 아닐 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkWinningNumberInput("1,2,3,a,4,5")
        }
    }

    @Test
    fun `당첨 번호가 1과 45 사이가 아닐 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkWinningNumberInput("1,2,3,4,5,70")
        }
    }

    @Test
    fun `당첨 번호가 중복일 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkWinningNumberInput("1, 2, 3, 4, 5, 5")
        }
    }

    val winningNumbers = Lotto(listOf(1,2,3,4,5,6))

    @Test
    fun `보너스 번호가 숫자가 아닐 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkBonusNumberInput(winningNumbers, "a")
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복될 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkBonusNumberInput(winningNumbers, "1")
        }
    }

    @Test
    fun `보너스 번호가 1과 45 사이가 아닐 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkBonusNumberInput(winningNumbers, "80")
        }
    }

}