package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class WinningTest {
    @Test
    fun `번호가 0,1,2개 일치할 때 LAST 반환`() {
        assertRank(NONE_MATCH, Rank.LAST)
    }

    @Test
    fun `번호가 3개 일치할 때 FIFTH 반환`() {
        assertRank(THREE_MATCH, Rank.FIFTH)
    }

    @Test
    fun `번호가 4개 일치할 때 FOURTH 반환`() {
        assertRank(FOUR_MATCH, Rank.FOURTH)
    }

    @Test
    fun `번호가 5개 일치할 때 THIRD 반환`() {
        assertRank(FIVE_MATCH, Rank.THIRD)
    }

    @Test
    fun `번호가 6개 일치할 때 FIRST 반환`() {
        assertRank(SIX_MATCH, Rank.FIRST)
    }

    @Test
    fun `번호 5개, 보너스 번호 일치할 때 THIRD 반환`() {
        assertRank(FIVE_BONUS_MATCH, Rank.SECOND)
    }


    private fun assertRank(matchCount: Int, expectedRank: Rank) {
        val winning = Winning()
        val resultRank = winning.createRankList(matchCount)
        assertThat(expectedRank).isEqualTo(resultRank)

    }

    @Test
    fun `5등이 하나도 없을 때 0 반환`() {
        val winning = Winning()
        val rankList = listOf(Rank.LAST, Rank.LAST, Rank.LAST)
        val resultFifthCount = winning.updateFifthCount(rankList)
        assertThat(0).isEqualTo(resultFifthCount)
    }

    @Test
    fun `4등이 1개 있을 때 1 반환`() {
        val winning = Winning()
        val rankList = listOf(Rank.LAST, Rank.LAST, Rank.FOURTH)
        val resultFourthCount = winning.updateFourthCount(rankList)
        assertThat(1).isEqualTo(resultFourthCount)
    }

    @Test
    fun `3등이 2개 있을 때 2 반환`() {
        val winning = Winning()
        val rankList = listOf(Rank.LAST, Rank.SECOND, Rank.SECOND)
        val resultThirdCount = winning.updateThirdCount(rankList)
        assertThat(2).isEqualTo(resultThirdCount)
    }

    @Test
    fun `2등이 하나도 없을 때 0 반환`() {
        val winning = Winning()
        val rankList = listOf(Rank.LAST, Rank.LAST, Rank.LAST)
        val resultSecondCount = winning.updateSecondCount(rankList)
        assertThat(0).isEqualTo(resultSecondCount)
    }

    @Test
    fun `1등이 1개 있을 때 1 반환`() {
        val winning = Winning()
        val rankList = listOf(Rank.LAST, Rank.LAST, Rank.FIRST)
        val resultFirstCount = winning.updateFirstCount(rankList)
        assertThat(1).isEqualTo(resultFirstCount)
    }

}