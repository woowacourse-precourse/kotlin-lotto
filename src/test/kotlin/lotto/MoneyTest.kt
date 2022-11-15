package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoneyTest {
    private val money = Money()

    @Test
    fun `getNumberOfPurchases()_2000 넣었을때_2반환`() {
        val result = 2
        money.money = "2000"
        assertThat(result).isEqualTo(money.getNumberOfPurchases())
    }

    @Test
    fun `getProfitRate()_8000원으로 5등 했을때_62점5반환`() {
        val result = 62.5
        money.money = "8000"
        assertThat(result).isEqualTo(money.getProfitRate(listOf(1, 0, 0, 0, 0)))
    }
}