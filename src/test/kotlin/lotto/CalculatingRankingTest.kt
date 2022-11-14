package lotto

import lotto.domain.CONSTANT
import lotto.domain.CalculateRanking
import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CalculatingRankingTest {
    @Test
    fun `당첨 번호와 로또 번호가 6개 일치`() {
        val result = CalculateRanking().countSameNumber(listOf(1,2,3,4,5,6), listOf(1,2,3,4,5,6))
        assertThat(result).isEqualTo(6)
    }
    @Test
    fun `당첨 번호와 로또 번호가 5개 일치`() {
        val result = CalculateRanking().countSameNumber(listOf(1,2,3,4,5,6), listOf(1,2,3,4,5,7))
        assertThat(result).isEqualTo(5)
    }
    @Test
    fun `당첨 번호와 로또 번호가 4개 일치`() {
        val result = CalculateRanking().countSameNumber(listOf(1,2,3,4,5,6), listOf(1,2,3,4,8,7))
        assertThat(result).isEqualTo(4)
    }
    @Test
    fun `당첨 번호와 로또 번호가 3개 일치`() {
        val result = CalculateRanking().countSameNumber(listOf(1,2,3,4,5,6), listOf(1,2,3,9,8,7))
        assertThat(result).isEqualTo(3)
    }
    @Test
    fun `당첨 번호와 로또 번호가 2개 일치`() {
        val result = CalculateRanking().countSameNumber(listOf(1,2,3,4,5,6), listOf(1,2,10,9,8,7))
        assertThat(result).isEqualTo(2)
    }
    @Test
    fun `로또 번호에 보너스 번호 있는 경우`() {
        val result = CalculateRanking().checkBonusInLotto(listOf(1,2,3,4,5,6),6)
        assertThat(result).isEqualTo(true)
    }
    @Test
    fun `로또 번호에 보너스 번호 없는 경우`() {
        val result = CalculateRanking().checkBonusInLotto(listOf(1,2,3,4,5,6),7)
        assertThat(result).isEqualTo(false)
    }
    @Test
    fun `1등 경우 확인`() {
        val result = CalculateRanking().calculateRanking(Lotto(listOf(1,2,3,4,5,6)), Lotto(listOf(1,2,3,4,5,6)),6)
        assertThat(result).isEqualTo(CONSTANT.RANKING.FIRST)
    }
    @Test
    fun `2등 경우 확인`() {
        val result = CalculateRanking().calculateRanking(Lotto(listOf(1,2,3,4,5,6)), Lotto(listOf(1,2,3,4,5,7)),1)
        assertThat(result).isEqualTo(CONSTANT.RANKING.SECOND)
    }
    @Test
    fun `3등 경우 확인`() {
        val result = CalculateRanking().calculateRanking(Lotto(listOf(1,2,3,4,5,6)), Lotto(listOf(1,2,3,4,5,7)),10)
        assertThat(result).isEqualTo(CONSTANT.RANKING.THIRD)
    }
    @Test
    fun `4등 경우 확인`() {
        val result = CalculateRanking().calculateRanking(Lotto(listOf(1,2,3,4,5,6)), Lotto(listOf(1,2,3,4,7,8)),6)
        assertThat(result).isEqualTo(CONSTANT.RANKING.FOURTH)
    }
    @Test
    fun `5등 경우 확인`() {
        val result = CalculateRanking().calculateRanking(Lotto(listOf(1,2,3,4,5,6)), Lotto(listOf(1,2,3,7,8,9)),6)
        assertThat(result).isEqualTo(CONSTANT.RANKING.FIFTH)
    }
}