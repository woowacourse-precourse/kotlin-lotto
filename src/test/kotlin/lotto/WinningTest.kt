package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class WinningTest {
    @Test
    fun `번호가 0,1,2개 일치할 때 LAST 반환`() {
        val winning = Winning()
        val resultRank = winning.updateRank(0)
        assertThat(Rank.LAST).isEqualTo(resultRank)

    }
}