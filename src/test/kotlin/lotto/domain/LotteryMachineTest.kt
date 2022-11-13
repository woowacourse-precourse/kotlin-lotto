package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LotteryMachineTest {

    @DisplayName("발행하려는 숫자에 맞게 복권 만들기")
    @Test
    fun operate() {
        val lottoCount = 5

        val lottoTicket = LotteryMachine().operate(lottoCount = 5)
        Assertions.assertThat(lottoCount).isEqualTo(lottoTicket.size)
    }
}
