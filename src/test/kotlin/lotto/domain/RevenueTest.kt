package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class RevenueTest {
    @Test
    fun `수익률 계산 테스트`() {
        val revenue = Revenue()
        val rankResult = mutableMapOf<Rank, Int>()

        //총 수익 = 2,031,555,000
        for(i in Rank.values()){
            rankResult[i] = 1
        }
        val purchasePrice = 1550000L

        assertEquals(revenue.getRevenue(rankResult, purchasePrice), 131068.06.toFloat())
    }
}