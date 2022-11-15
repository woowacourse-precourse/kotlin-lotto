package lotto.domainTest

import lotto.domain.Calculator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `총 당첨 금액 계산`() {

        val countRankings: HashMap<Int, Int> = hashMapOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 1), Pair(4, 0), Pair(5, 2))
        val result = calculator.sumPrizes(countRankings)
        Assertions.assertThat(result).isEqualTo(1_510_000)
    }

    @Test
    fun `등수로 당첨 금액 확인`() {
        val rank = 2
        val result = calculator.prizeMoney(rank)
        Assertions.assertThat(result).isEqualTo(30_000_000)
    }

    @Test
    fun `수익률 계산`() {
        val purchase = 1000
        val sumPrizes = 5000
        val result = calculator.calculateYield(purchase, sumPrizes)
        Assertions.assertThat(result).isEqualTo(500.0)
    }
}