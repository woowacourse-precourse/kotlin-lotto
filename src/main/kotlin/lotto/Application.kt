package lotto

import lotto.domain.Calculator
import lotto.domain.CountRankings
import lotto.domain.RandomGenerator

fun main() {
    val lottos = mutableListOf<Lotto>()
    val count = 4
    val winningNumber = listOf(11,22,24,6,35,42)
    val bonusNumber = 7
    for (index in 0..10){
        val lotto = Lotto(RandomGenerator().createRandomNumbers())
        lottos.add(lotto)
        println(lotto.getNumbers())
    }
    println(CountRankings().countRankings(winningNumber,bonusNumber,lottos))
    println(Calculator().sumPrizes(CountRankings().countRankings(winningNumber,bonusNumber,lottos)))
}
