package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.domain.LottoMachine
import lotto.domain.LottoMachine.Companion.BONUS_DUPLICATED
import lotto.domain.LottoMachine.Companion.INPUT_NOT_NATURAL_NUMBER
import lotto.domain.LottoMachine.Companion.INVALID_NUMBER_OF_WINNING_NUMBERS
import lotto.domain.LottoMachine.Companion.INVALID_NUMBER_RANGE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoMachineTest {
    private val lottoMachine = LottoMachine()

    @Test
    fun `당첨번호 생성 확인`() {
        lottoMachine.publishWinningNumber("1,2,3,4,5,6")
        assertThat(lottoMachine.winningNumbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `당첨번호가 숫자가 아닐 경우 예외가 발생한다`() {
        assertSimpleTest {
            assertThatThrownBy {
                lottoMachine.publishWinningNumber("1,2,3,가,나")
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(INPUT_NOT_NATURAL_NUMBER)
        }
    }

    @Test
    fun `당첨번호가 1~45가 아닐 경우 예외가 발생한다`() {
        assertSimpleTest {
            assertThatThrownBy {
                lottoMachine.publishWinningNumber("1,2,3,30,50")
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(INVALID_NUMBER_RANGE)
        }
    }

    @Test
    fun `당첨번호가 6자리가 아닐 경우 예외가 발생한다`() {
        assertSimpleTest {
            assertThatThrownBy {
                lottoMachine.publishWinningNumber("1,2,3,4,5,6,7")
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(INVALID_NUMBER_OF_WINNING_NUMBERS)
        }
    }

    @Test
    fun `보너스 번호 생성 확인`() {
        lottoMachine.publishBonusNumber("30")
        assertThat(lottoMachine.bonusNumber).isEqualTo(30)
    }

    @Test
    fun `보너스 번호가 숫자가 아닐 경우 예외가 발생한다`() {
        assertSimpleTest {
            assertThatThrownBy {
                lottoMachine.publishWinningNumber("가나")
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(INPUT_NOT_NATURAL_NUMBER)
        }
    }

    @Test
    fun `보너스 번호가 1~45가 아닐 경우 예외가 발생한다`() {
        assertSimpleTest {
            assertThatThrownBy {
                lottoMachine.publishBonusNumber("70")
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(INVALID_NUMBER_RANGE)
        }
    }

    @Test
    fun `보너스번호가 당첨번호와 중복되면 예외가 발생한다`() {
        assertSimpleTest {
            assertThatThrownBy {
                lottoMachine.publishWinningNumber("1,2,3,4,5,6")
                lottoMachine.publishBonusNumber("6")
            }.isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(BONUS_DUPLICATED)
        }
    }
}
