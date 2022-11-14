package lotto

import lotto.domain.Calculator
import lotto.domain.CountRankings
import lotto.domain.RandomGenerator

fun main() {
    val lottos = mutableListOf<Lotto>()
    val calculator = Calculator()
    val count = 100
    val winningNumber = listOf(11,22,24,6,35,42)
    val bonusNumber = 7
    for (index in 0 until count){
        val lotto = Lotto(RandomGenerator().createRandomNumbers())
        lottos.add(lotto)
        println(lotto.getNumbers())
    }
    println(CountRankings().countRankings(winningNumber,bonusNumber,lottos))
    val num= calculator.sumPrizes(CountRankings().countRankings(winningNumber,bonusNumber,lottos))
    println(num)
    println("수익률:"+calculator.calculateYield(count*1000,num))
}
