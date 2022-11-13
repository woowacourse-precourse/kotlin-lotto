package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoVendingMachineTest {
    @Test
    fun isEnoughMoneyTest(){
        assertThat(isEnoughMoney(2000)).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            isEnoughMoney(800)
        }
    }

    @Test
    fun isMoney1000Test(){
        assertThat(isMoney1000(1000)).isEqualTo(1)
        assertThat(isMoney1000(1400)).isEqualTo(1)
    }
}