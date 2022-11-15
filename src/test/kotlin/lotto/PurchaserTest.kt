package lotto

import lotto.domain.Lotto
import lotto.domain.customer.MatchedCount
import lotto.domain.customer.Purchaser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PurchaserTest {
    private val purchaser = Purchaser()

    @Test
    fun `로또 비교 로직 확인`() {
        val lotteries = listOf<Lotto>(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )
        val winningNumbers = listOf<Int>(6, 7, 8, 9, 10, 11)
        val bonusNumber = 12
        val resultMap = mapOf<MatchedCount, Int>(
            MatchedCount.TRHEE to 0,
            MatchedCount.FOUR to 0,
            MatchedCount.FIVE to 0,
            MatchedCount.FIVE_BONUS to 1,
            MatchedCount.SIX to 0
        )
        purchaser.receivePurchasedLotteries(lotteries)
        assertThat(purchaser.calculateRank(winningNumbers, bonusNumber)).isEqualTo(resultMap)
    }

    @Test
    fun `돈을 적합하게 지불했는지 확인`() {
        assertThat(purchaser.payMoney("3000")).isEqualTo(3000)
    }

    @Test
    fun `수익률 계산 확인`() {
        val lotteries = listOf<Lotto>(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(13, 14, 16, 38, 42, 45)),
            Lotto(listOf(7, 11, 30, 40, 42, 43)),
            Lotto(listOf(2, 13, 22, 32, 38, 45)),
            Lotto(listOf(1, 3, 5, 14, 22, 45))
        )
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        purchaser.payMoney("8000")
        purchaser.receivePurchasedLotteries(lotteries)
        purchaser.calculateRank(winningNumbers, bonusNumber)
        assertThat(purchaser.calculateEarningRate()).isEqualTo("62.5")
    }
}
