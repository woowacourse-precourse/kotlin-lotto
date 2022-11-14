package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class WinningTest {
    @Test
    fun `번호가 0,1,2개 일치할 때 LAST 반환`() {
        assertRank(0, Rank.LAST)
    }

    @Test
    fun `번호가 3개 일치할 때 FIFTH 반환`() {
        assertRank(3, Rank.FIFTH)
    }

    @Test
    fun `번호가 4개 일치할 때 FOURTH 반환`() {
        assertRank(4, Rank.FOURTH)
    }


    private fun assertRank(matchCount: Int, expectedRank: Rank) {
        val winning = Winning()
        val resultRank = winning.updateRank(matchCount)
        assertThat(expectedRank).isEqualTo(resultRank)

    }
}