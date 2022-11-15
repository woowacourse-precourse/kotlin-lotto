package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LotteryCheckerTest {

    @BeforeAll
    fun setUp() {
        lotteryChecker.checkLotteryNumber(winningLottery, lottoTicket)
    }

    @Test
    @DisplayName("당첨번호와 보너스 번호를 이용하여, 복권 당첨 등수 확인하는 테스트")
    fun `복권_당첨_등수_확인`() {
        for (rank in Rank.values()) {
            when (rank) {
                Rank.FAIL ->
                    Assertions.assertThat(3).isEqualTo(lotteryChecker.getWinnerScore(rank))
                else ->
                    Assertions.assertThat(1).isEqualTo(lotteryChecker.getWinnerScore(rank))
            }
        }
    }

    @Test
    @DisplayName("복권에 당첨된 모든 등수의 상금 합을 구하여 값이 맞는 지 확인하는 테스트")
    fun `당첨된_모든_등수_총금액_비교_확인`() {
        val result: Long = 2031555000
        Assertions.assertThat(result).isEqualTo(lotteryChecker.getTotalWinnerPrice())
    }

    companion object {
        private var lotteryChecker: LotteryChecker = LotteryChecker()
        private val winningLottery = WinningLottery("12,13,14,15,16,40", 30)
        private val lottoTicket = mutableListOf<Lotto>()

        @BeforeAll
        @JvmStatic
        fun `초기화`() {
            createLotto()
        }

        private fun createLotto() {
            lottoTicket.add(Lotto(listOf(1, 2, 3, 4, 5, 6))) /* 하나도 맞지 않음 */
            lottoTicket.add(Lotto(listOf(1, 12, 3, 4, 5, 6))) /* 1개 맞음 */
            lottoTicket.add(Lotto(listOf(13, 12, 3, 33, 35, 29))) /* 2개 맞음 */
            lottoTicket.add(Lotto(listOf(13, 12, 14, 33, 35, 29))) /* 3개 맞음 */
            lottoTicket.add(Lotto(listOf(22, 12, 14, 15, 13, 6))) /* 4개 맞음 */
            lottoTicket.add(Lotto(listOf(22, 12, 14, 15, 13, 16))) /* 5개 맞음 */
            lottoTicket.add(Lotto(listOf(12, 13, 14, 15, 16, 30))) /* 5개 맞고 보너스 */
            lottoTicket.add(Lotto(listOf(12, 13, 14, 15, 16, 40))) /* 6개 맞음 */
        }
    }
}
