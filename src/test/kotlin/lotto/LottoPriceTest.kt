package lotto

import lotto.domain.LottoProfit
import lotto.domain.LottoWin
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoPriceTest {
    @Test
    fun `수익률을 출력한다`() {
        val result = LottoProfit(listOf(0,0,0,0,1),1000).calLottoProfit()
        Assertions.assertThat(result).isEqualTo(2000000.0)
    }
}