package lotto.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class YieldCalculatorTest {

    private val yieldCalculator = YieldCalculator()
    private val money = arrayOf(2000000000, 30000000, 1500000, 50000, 5000)

    @Test
    fun `2등 1개 당첨됐을 때 당첨금 계산`(){
        val result = yieldCalculator.getWinMoney(listOf(0,1,0,0,0))
        assertThat(result).isEqualTo(money[1])
    }

    @Test
    fun `2등 1개 5등 1개 당첨됐을 때 당첨금 계산`(){
        val result = yieldCalculator.getWinMoney(listOf(0,1,0,0,1))
        assertThat(result).isEqualTo(money[1] + money[4])
    }

    @Test
    fun `1등 1개 3등 1개 5등 1개 당첨됐을 때 당첨금 계산`(){
        val result = yieldCalculator.getWinMoney(listOf(1,0,1,0,1))
        assertThat(result).isEqualTo(money[0] + money[2] + money[4])
    }

    @Test
    fun `8000원 투자 5000원 당첨 수익률 계산`(){
        val result = yieldCalculator.getYield(5000,8000)
        assertThat(result).isEqualTo(62.5)
    }

    @Test
    fun `9000원 투자 50000원 당첨 수익률 계산`(){
        val result = yieldCalculator.getYield(50000,9000)
        assertThat(result).isEqualTo(555.6)
    }

}