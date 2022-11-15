package lotto.view

import lotto.utils.*
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class InputViewTest {
    private lateinit var inputView: InputView

    @BeforeEach
    fun setUp() {
        inputView = InputView()
    }

    @Test
    fun `로또 구입 금액 입력에 대한 예외 처리`() {
        assertThatThrownBy {
            inputView.validateUserMoney("1000j")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(MIXED_CHAR_ERROR_MSG)

        assertThatThrownBy {
            inputView.validateUserMoney("1234")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(DIVISION_ERROR_MSG)
    }

    @Test
    fun `당첨 번호 입력에 대한 예외 처리`() {
        assertThatThrownBy {
            inputView.validateWinningNumbers("1,2,k,4,5,j")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(MIXED_CHAR_ERROR_MSG)

        assertThatThrownBy {
            inputView.validateWinningNumbers("46,1,4,0,99,100")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(RANGE_BOUNDS_ERROR_MSG)

        assertThatThrownBy {
            inputView.validateWinningNumbers("1,2,2,3,4,5")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(WINNING_DUPLICATE_ERROR_MSG)

        assertThatThrownBy {
            inputView.validateWinningNumbers("1,2,3,4,5,6,7")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(SIZE_BOUNDS_ERROR_MSG)

//        assertThrows<IllegalArgumentException> {
//            inputView.validateWinningNumbers("1,2,3,4,5,6,")
//        }
//        assertThrows<IllegalArgumentException> {
//            inputView.validateWinningNumbers("1,,,4,5,6")
//        }
    }

    @Test
    fun `보너스 번호 입력에 대한 예외 처리`() {
        val winningNumbers = listOf(1,2,3,4,5,6)

        assertThatThrownBy {
            inputView.validateBonusNumber("asdf", winningNumbers)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(MIXED_CHAR_ERROR_MSG)

        assertThatThrownBy {
            inputView.validateBonusNumber("46", winningNumbers)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(RANGE_BOUNDS_ERROR_MSG)

        assertThatThrownBy {
            inputView.validateBonusNumber("6", winningNumbers)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(BONUS_DUPLICATE_ERROR_MSG)
    }
}