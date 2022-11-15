package lotto.view

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows

internal class InputViewTest {
    private lateinit var inputView: InputView

    @BeforeEach
    fun setUp() {
        inputView = InputView()
    }

    @Test
    fun `로또 구입 금액 입력에 대한 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateUserMoney("1000j")
        }
        assertThrows<IllegalArgumentException> {
            inputView.validateUserMoney("1234")
        }
    }

    @Test
    fun `당첨 번호 입력에 대한 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateWinningNumbers("1,2,k,4,5,j")
        }
        assertThrows<IllegalArgumentException> {
            inputView.validateWinningNumbers("46,1,4,0,99,100")
        }
        assertThrows<IllegalArgumentException> {
            inputView.validateWinningNumbers("1,2,2,3,4,5")
        }
        assertThrows<IllegalArgumentException> {
            inputView.validateWinningNumbers("1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `보너스 번호 입력에 대한 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateBonusNumber("asdf")
        }
        assertThrows<IllegalArgumentException> {
            inputView.validateBonusNumber("46")
        }
    }
}