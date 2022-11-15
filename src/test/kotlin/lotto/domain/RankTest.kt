package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RankTest {

    @Test
    @DisplayName("당첨번호와 구매한 로또 사이에 매칭된 수와 존재하는 보너스 여부에 따라 당첨등수 확인")
    fun `당첨_등수_확인`() {
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
