package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun calculateYield(winRanks: Map<LottoRank, Int>, lottoMoney: Int): Float {
    var winMoney = 0
    for ((k, v) in winRanks) {
        winMoney += k.value * v
    }
    return winMoney / lottoMoney * 100f
}

fun calculateWinRanks(lottos: List<Lotto>, winNumber: List<Int>, bonusNumber: Int): Map<LottoRank, Int> {
    val rankMap = mutableMapOf<LottoRank, Int>()
    for (i in lottos) {
        val calculatedRank = i.calculateWinRank(winNumber, bonusNumber)
        rankMap[calculatedRank] = (rankMap[calculatedRank] ?: 0) + 1
    }
    return rankMap
}

fun produceLotto(amount: Int): List<Lotto> {
    val lottos = mutableListOf<Lotto>()

    for (i in 0 until amount) {
        val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        lottos.add(lotto)
    }

    return lottos
}

fun getInputBonusNumber(): Int {
    val input = Console.readLine()

    return input.toIntOrNull() ?: throw IllegalArgumentException()
}

fun getInputWinNumbers(): List<Int> {
    val input = Console.readLine().split(",")

    if (input.size != 6)
        throw IllegalArgumentException()

    val winNumbers = input.map {
        it.toIntOrNull() ?: throw IllegalArgumentException()
    }

    return winNumbers
}

fun getInputLottoMoney(): Int {
    val input = Console.readLine()
    val lottoMoney = input.toIntOrNull() ?: throw IllegalArgumentException()

    if (lottoMoney % 1000 != 0)
        throw IllegalArgumentException()

    return lottoMoney
}

fun main() {
    TODO("프로그램 구현")
}
