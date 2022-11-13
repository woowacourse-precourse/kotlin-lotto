package lotto

import machine.Machine
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MachineTest {
    @Test
    fun `입력 금액 테스트`() {
        assertThrows<IllegalArgumentException> {
            Machine(12345)
        }
    }

    @Test
    fun `로또번호 출력`() {
        val machine = Machine(12000)
        val count = machine.inputMoney / 1000
        assert(machine.makeLottoNumbers(count).size == 12)
    }
}
