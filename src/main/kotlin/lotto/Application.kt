package lotto

import camp.nextstep.edu.missionutils.Randoms

var winnings: List<String> = listOf()

fun main() {
    val money = LottoCount().inputMoney()
    val lottoCount = LottoCount().printLottoConut(money)
    val allLotto = publishLotto(lottoCount)
    winnings = Number().inputWinningNumber()
    val bonusNum = Number().inputBonusNumber()

    var winningCounts = mutableListOf<Int>()
    allLotto.forEach {
        winningCounts = Lotto(it.toList()).calculateLottoWin(lottoCount, allLotto, bonusNum)
    }

    Score().printWinningScore(winningCounts)
    Score().printWinningRate(winningCounts, money)
}

fun publishLotto(lottoCount: Int): Array<IntArray> {
    var allLotto = Array(lottoCount) { IntArray(6) }
    for (i in 0 until lottoCount) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 20, 6)
        Lotto(numbers)
        println(numbers.sorted())
        allLotto[i] = numbers.toIntArray()
    }
    return allLotto
}
