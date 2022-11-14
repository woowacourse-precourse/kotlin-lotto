package lotto

import lotto.LottoVendingMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoVendingMachineTest {
    val machine = LottoVendingMachine()
    @Test
    fun isEnoughMoneyTest(){
        assertThat(machine.isEnoughMoney(2000)).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            machine.isEnoughMoney(800)
        }
    }

    @Test
    fun isMoney1000Test(){
        assertThat(machine.isMoney1000(1000)).isEqualTo(1)
        assertThat(machine.isMoney1000(1400)).isEqualTo(1)
    }
}