package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPrizeTest {
    @ParameterizedTest
    @CsvSource(
        "NO_WINNING_AMOUNT,0",
        "FIFTH_PRIZE,5000",
        "FOURTH_PRIZE,50000",
        "THIRD_PRIZE,1500000",
        "SECOND_PRIZE,30000000",
        "FIRST_PRIZE,2000000000"
    )
    fun `로또 당첨금 테스트`(prize: String, winningAmount: Int) {
        val result = LottoPrize.valueOf(prize).winPrize()
        assertThat(result).isEqualTo(winningAmount)
    }

}