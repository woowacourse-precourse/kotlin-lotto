package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import kotlin.math.*

class LottoStatisticsTest {
    private val winning = listOf(1, 2, 3, 4, 5, 6)
    private val bonus = 7
    private val lottos = listOf(
        Lotto(listOf(8, 21, 23, 41, 42, 43)),
        Lotto(listOf(3, 5, 11, 16, 32, 38)),
        Lotto(listOf(7, 11, 16, 35, 36, 44)),
        Lotto(listOf(1, 8, 11, 31, 41, 42)),
        Lotto(listOf(13, 14, 16, 38, 42, 45)),
        Lotto(listOf(7, 11, 30, 40, 42, 43)),
        Lotto(listOf(2, 13, 22, 32, 38, 45)),
        Lotto(listOf(1, 3, 5, 14, 22, 45))
    )

    @Test
    fun `구매한 로또들을 통계 내주는데 1,0,0,0,0 당첨인 경우`() {
        val result = mutableListOf(0, 0, 0, 0, 0, 0)
        lottos.forEach { result[it.matchResult(winning, bonus).index]++ }
        val expected = listOf(1, 0, 0, 0, 0)
        assertThat(result.subList(0, 5)).isEqualTo(expected)
    }

    @Test
    fun `수익률 62_5%를 구하는 경우`() {
        val expected = 62.5
        var sum = 0.0
        val lottoStatistics = LottoStatistics()
        val statistics = lottoStatistics.statisticsLotto(lottos, winning, bonus)
        for (i in statistics.indices) {
            sum += when (i) {
                MatchResult.THREE.index -> MatchResult.THREE.money * statistics[i]
                MatchResult.FOUR.index -> MatchResult.FOUR.money * statistics[i]
                MatchResult.FIVE.index -> MatchResult.FIVE.money * statistics[i]
                MatchResult.BONUS.index -> MatchResult.BONUS.money * statistics[i]
                else -> MatchResult.SIX.money * statistics[i]
            }
        }
        val tmp: Double = sum / (lottos.size * 1000) * 100
        val result = round(tmp * 10) / 10
        assertThat(result).isEqualTo(expected)
    }

}