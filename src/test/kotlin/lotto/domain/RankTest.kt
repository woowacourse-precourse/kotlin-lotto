package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RankTest {

    @Test
    fun `당첨 등수 확인하는 기능`() {
        Assertions.assertThat(Rank.FIRST).isEqualTo(Rank.valueOf(6, true))
        Assertions.assertThat(Rank.FIRST).isEqualTo(Rank.valueOf(6, false))
        Assertions.assertThat(Rank.SECOND).isEqualTo(Rank.valueOf(5, true))
        Assertions.assertThat(Rank.THIRD).isEqualTo(Rank.valueOf(5, false))
        Assertions.assertThat(Rank.FOURTH).isEqualTo(Rank.valueOf(4, true))
        Assertions.assertThat(Rank.FOURTH).isEqualTo(Rank.valueOf(4, false))
        Assertions.assertThat(Rank.FIFTH).isEqualTo(Rank.valueOf(3, true))
        Assertions.assertThat(Rank.FIFTH).isEqualTo(Rank.valueOf(3, false))
        Assertions.assertThat(Rank.FAIL).isEqualTo(Rank.valueOf(2, false))
    }
}
