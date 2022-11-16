package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    @Test
    fun `로또 입력 금액 예외 테스트 - 1000원 단위가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine(54300)
        }
    }

    @Test
    fun `로또 입력 금액 예외 테스트 - 1000원 보다 적은 경우`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine(600)
        }
    }

    @Test
    fun `로또 입력 금액 예외 테스트 - 음수인 경우`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine(-3000)
        }
    }

    @Test
    fun `로또 생성 갯수 확인 테스트`() {
        assertThat(LottoMachine(3000).generate().size).isEqualTo(3)
    }
}