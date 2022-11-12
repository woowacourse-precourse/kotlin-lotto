package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun calculateYield(lottos: List<Lotto>, winNumber: List<Int>, bonusNumber: Int): Float {
    return 0f
}

fun calculateWinRanks(lottos: List<Lotto>, winNumber: List<Int>, bonusNumber: Int): Map<LottoRank, Int> {
    return mapOf()
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
