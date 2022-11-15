package lotto.domainTest

import lotto.Lotto
import lotto.domain.CountRankings
import lotto.domain.RandomGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.random.Random

class CountRankingsTest {
    @Test
    fun `로또 몇등 몇개`() {
        val countRankings = CountRankings()
        val lottos= listOf(Lotto(listOf(1,2,3,4,5,6)),Lotto(listOf(7,8,9,10,11,12)))
        val winning= listOf(1,2,3,10,11,12)
        val bonus = 5
        val result = countRankings.countRankings(winning,bonus,lottos)
        val test:HashMap<Int,Int> = hashMapOf(Pair(0,0),Pair(1,0),Pair(2,0),Pair(3,0),Pair(4,0),Pair(5,2))
        Assertions.assertThat(result).isEqualTo(test)
    }
}