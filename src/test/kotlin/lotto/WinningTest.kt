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
        val resultRank = winning.updateRank(matchCount)
        assertThat(expectedRank).isEqualTo(resultRank)

    }
}