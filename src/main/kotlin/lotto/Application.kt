package lotto

import camp.nextstep.edu.missionutils.Console

fun calculateYield(lottos: List<Lotto>, winNumber: List<Int>, bonusNumber: Int): Float {
    return 0f
}

fun calculateWinRanks(lottos: List<Lotto>, winNumber: List<Int>, bonusNumber: Int): Map<LottoRank, Int> {
    return mapOf()
}

fun generateLottoNumbers(): Lotto {
    return Lotto(listOf(1,2,3,4,5,6))
}

fun produceLotto(amount: Int): List<Lotto> {
    return listOf(Lotto(listOf(1,2,3,4,5,6)))
}

fun getInputBonusNumber(): Int {
    return 0
}

fun getInputWinNumber(): List<Int> {
    return listOf()
}

fun getInputLottoMoney(): Int {
    val input = Console.readLine()
    val intInput = input.toIntOrNull() ?: throw IllegalArgumentException()

    if (intInput % 1000 != 0)
        throw IllegalArgumentException()

    return intInput
}

fun main() {
    TODO("프로그램 구현")
}
