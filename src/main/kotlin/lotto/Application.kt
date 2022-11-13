package lotto

import lotto.domain.CountRankings
import lotto.domain.RandomGenerator

fun main() {
    val lottos = mutableListOf<Lotto>()
    val count = 4
    val winningNumber = listOf(1,2,3,4,5,6)
    val bonusNumber = 7
    for (index in 0..3){
        val lotto = Lotto(RandomGenerator().createRandomNumbers())
        lottos.add(lotto)
        println(lotto.getNumbers())
    }
    println(CountRankings().countRankings(winningNumber,bonusNumber,lottos))
}
