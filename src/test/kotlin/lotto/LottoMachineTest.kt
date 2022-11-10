package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {
    @ParameterizedTest
    @CsvSource("1000, 1", "14000, 14")
    fun `로또를 금액만큼 발행한다`(money: Int, lottoCount: Int) {
        val lottoTicketCount = LottoMachine(money).sellLottos()
        assertThat(lottoTicketCount).isEqualTo(lottoCount)
    }
}