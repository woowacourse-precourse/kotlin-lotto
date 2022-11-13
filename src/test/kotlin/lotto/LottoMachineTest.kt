package lotto

import lotto.domain.store.LottoMachine
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

    @ParameterizedTest
    @CsvSource("1000,1", "2000,2", "14000,14", "0,0")
    fun `생성된 로또 개수 확인 테스트`(money: Int, count: Int) {
        val result = LottoMachine(money).createLottos().size
        assertThat(result).isEqualTo(count)
    }
}