package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LotteryMachineTest {

    @Test
    @DisplayName("구입금액으로 발행할 수 있는 복권 수에 맞게 복권을 만드는 기능 테스트")
    fun `발행수에_맞게_복권을_발행했는지_확인`() {
        val lottoCount = 5

        val lottoTicket = LotteryMachine().operate(lottoCount = 5)
        Assertions.assertThat(lottoCount).isEqualTo(lottoTicket.size)
    }
}
