package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoTest {
    @Nested
    inner class `로또 당첨 등수 반환 테스트` {
        @Test
        fun case1() {
            assertThat(
                Lotto(listOf(1, 3, 5, 14, 22, 45)).getWinningRank(
                    listOf(1, 2, 3, 4, 5, 6),
                    7
                )
            ).isEqualTo(Winning.FIFTH.ordinal)
        }

        @Test
        fun case2() {
            assertThat(
                Lotto(listOf(1, 3, 5, 14, 22, 45)).getWinningRank(
                    listOf(1, 22, 14, 5, 3, 45),
                    7
                )
            ).isEqualTo(Winning.FIRST.ordinal)
        }

        @Test
        fun case3() {
            assertThat(
                Lotto(listOf(1, 3, 5, 14, 22, 45)).getWinningRank(
                    listOf(1, 3, 14, 22, 5, 7),
                    45
                )
            ).isEqualTo(Winning.SECOND.ordinal)
        }
    }
}
