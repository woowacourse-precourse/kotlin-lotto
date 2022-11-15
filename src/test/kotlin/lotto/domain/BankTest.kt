package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BankTest{
    private lateinit var bank : Bank

    @BeforeEach
    fun setup(){
        bank = Bank(listOf(listOf(1,2,3,4,5,6), listOf(10,11,12,13,14,15), listOf(1,2,3,4,5,7)))
        bank.writeWinStatistic(listOf(1,2,3,4,5,6) , 7)
    }

    @Test
    fun `당첨 통계가 잘 작성되는지 확인`(){
        assertThat(bank.winStatistic[Win.FIRST_PLACE]).isEqualTo(1)
    }

    @Test
    fun `총 수입을 제대로 가져오는지 확인`(){
        val answer = 2030000000L
        assertThat(bank.getTotalIncome()).isEqualTo(answer)
    }

    @Test
    fun `수익률을 제대로 가져오는 확인`(){
        val purchasingAmount = 10000L
        val rateOfReturn = bank.getRateOfReturn(bank.getTotalIncome(),purchasingAmount)
        val answer = 2.03E7
        assertThat(rateOfReturn).isEqualTo(answer)
    }
}