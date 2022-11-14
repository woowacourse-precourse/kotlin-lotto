package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    private val lottoMachine = LottoMachine()

    @Test
    fun `당첨번호 생성 확인`() {
        lottoMachine.publishWinningNumber("1,2,3,4,5,6")
        Assertions.assertThat(lottoMachine.winningNumbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `당첨번호가 숫자가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.publishWinningNumber("1,2,3,가,나")
        }
    }

    @Test
    fun `당첨번호가 1~45가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.publishWinningNumber("1,2,3,30,50")
        }
    }

    @Test
    fun `당첨번호가 6자리가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.publishWinningNumber("1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `보너스 번호 생성 확인`() {
        lottoMachine.publishBonusNumber("30")
        Assertions.assertThat(lottoMachine.bonusNumber).isEqualTo(30)
    }

    @Test
    fun `보너스 번호가 숫자가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.publishWinningNumber("가나")
        }
    }

    @Test
    fun `보너스 번호가 1~45가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.publishBonusNumber("70")
        }
    }
}
