package lotto.domainTest

import lotto.domain.RandomGenerator
import lotto.domain.Ranking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RankingTest {
    @Test
    fun `6개는 1등`() {
        val ranking = Ranking()
        val result = ranking.checkRanking(6,false)
        Assertions.assertThat(result).isEqualTo(1)
    }

    @Test
    fun `5개에 보너스는 2등`() {
        val ranking = Ranking()
        val result = ranking.checkRanking(5,true)
        Assertions.assertThat(result).isEqualTo(2)
    }

    @Test
    fun `4개에 보너스는 4등`() {
        val ranking = Ranking()
        val result = ranking.checkRanking(4,true)
        Assertions.assertThat(result).isEqualTo(4)
    }
}