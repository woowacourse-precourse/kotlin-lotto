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

}
