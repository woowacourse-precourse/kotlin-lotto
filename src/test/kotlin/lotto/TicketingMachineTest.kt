package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class TicketingMachineTest {
    private val ticketingMachine = TicketingMachine()

    @Test
    fun `개수만큼 로또 발행`() {
        val result = ticketingMachine.createLottoNumbers(5)
        Assertions.assertThat(result).hasSize(5)
    }
}
