package lotto

import domain.LottoGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("LottoGame 테스트")
class LottoGameTest {

    @Test
    @DisplayName("Rank가 정확히 집계되는지 테스트")
    fun testRankingCount() {
        val lotteryGame = LottoGame(1)
        lotteryGame.createTestLotto()
        lotteryGame.createWinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val rankResult = lotteryGame.makeWinner()
        println(rankResult)
        for (rank in rankResult.keys) {
            if (rankResult[rank] != 0) {
                assertThat(rankResult[rank]).isEqualTo(1)
            }
        }
    }

    @Test
    @DisplayName("수익률이 정확히 집계되는지 테스트")
    fun testRankingPercent() {
        val lotteryGame = LottoGame(6)
        lotteryGame.createTestLotto()
        lotteryGame.createWinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val rankResult = lotteryGame.makeWinner().toMutableMap()
        val percent: Double = lotteryGame.makeRankPercent(rankResult)
        assertThat(percent).isEqualTo(30000.0 / (6 * 1000))
    }
}
