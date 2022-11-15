package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LotteryCheckerTest {

    @BeforeAll
    fun setUp() {
        lotteryChecker.checkLotteryNumber(winningLottery, lottoTicket)
    }

    @Test
    fun `가지고있는 로또를 당첨번호와 비교하는 기능`() {
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
    fun `총금액 구하는 기능`() {
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
