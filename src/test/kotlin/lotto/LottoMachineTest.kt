package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    private val lottoMachine: LottoMachine = LottoMachine()

    @Test
    fun `로또 구입 개수 구하기 테스트`() {
        assertThat(lottoMachine.getNumberOfLottos("8000")).isEqualTo(8)
        assertThat(lottoMachine.getNumberOfLottos("12000")).isEqualTo(12)
        assertThat(lottoMachine.getNumberOfLottos("0")).isEqualTo(0)
    }

    @Test
    fun `로또 구입 금액 입력이 숫자가 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.checkPaymentException("1000j")
        }
    }

    @Test
    fun `로또 구입 금액이 1000원 단위가 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.checkPaymentException("9800")
        }
    }

    @Test
    fun `당첨 번호 입력 형식이 아닐 때 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.convertNumbersToLotto("1 2 3 4 5 6")
        }
    }

    @Test
    fun `당첨 번호가 6개가 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.convertNumbersToLotto("1,2,3,4,5")
        }
    }

    @Test
    fun `당첨 번호가 숫자가 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.convertNumbersToLotto("1,2,a,b,5,6")
        }
        assertThrows<IllegalArgumentException> {
            lottoMachine.convertNumbersToLotto("!,2,3,4,5,6")
        }
    }

    @Test
    fun `당첨 번호 중 1~45 범위를 벗어나는 수가 있으면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.convertNumbersToLotto("100,2,3,4,5,6")
        }
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.convertNumbersToLotto("1,2,4,4,5,5")
        }
    }

    @Test
    fun `당첨 번호 정렬 확인`() {
        assertThat(lottoMachine.convertNumbersToLotto("3,4,2,6,1,5").getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

}