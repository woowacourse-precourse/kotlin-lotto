package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    private val machine = LottoMachine("1000")

    @Test
    fun `로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            (machine.validateUnitAmount("5500"))
        }
    }

    @Test
    fun `로또 구입 금액에 숫자가 아닌 문자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { (machine.validateTypeAmount("1000q")) }
    }
}