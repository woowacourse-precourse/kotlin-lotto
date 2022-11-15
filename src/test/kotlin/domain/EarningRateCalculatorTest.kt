package domain

import domain.EarningRateCalculator
import domain.MatchStorage
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import program.LottoProgram

class EarningRateCalculatorTest {

    @Test
    fun `수익률이 둘 째 자리에서 반올림이 되는지`() {
        val purchaseMoney = 9000
        MatchStorage.MATCH_FOUR.matchCount = 6
        val obj = EarningRateCalculator(purchaseMoney)
        obj.calculateEarningRate()
        Assertions.assertThat(obj.earningRate).isEqualTo(3333.3)
        initializeMatchStorage()
    }
}