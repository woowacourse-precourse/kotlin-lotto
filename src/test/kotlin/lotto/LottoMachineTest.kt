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

}