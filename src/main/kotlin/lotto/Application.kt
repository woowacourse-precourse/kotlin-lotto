package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.StringBuilder

fun calculateYield(winRanks: Map<LottoRank, Int>, lottoMoney: Int): Float {
    var winMoney = 0f
    for ((k, v) in winRanks) {
        winMoney += k.value * v
    }
    return (winMoney / lottoMoney) * 100f
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

fun formatWinRanks(winRanks: Map<LottoRank, Int>): String {
    val formattedRank = StringBuilder()
    formattedRank.append("3개 일치 (5,000원) - ${winRanks[LottoRank.FIFTH] ?: 0}개\n")
    formattedRank.append("4개 일치 (50,000원) - ${winRanks[LottoRank.FOURTH] ?: 0}개\n")
    formattedRank.append("5개 일치 (1,500,000원) - ${winRanks[LottoRank.THIRD] ?: 0}개\n")
    formattedRank.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winRanks[LottoRank.SECOND] ?: 0}개\n")
    formattedRank.append("6개 일치 (2,000,000,000원) - ${winRanks[LottoRank.FIRST] ?: 0}개\n")
    return formattedRank.toString()
}

fun formatYield(yield: Float): String {
    return String.format("총 수익률은 %.2f%입니다.", `yield`)
}

fun main() {
    val lottoMoney = getInputLottoMoney()
    val lottos = produceLotto(lottoMoney / 1000)
    val winNumber = getInputWinNumbers()
    val bonusNumber = getInputBonusNumber()
    val winRanks = calculateWinRanks(lottos, winNumber, bonusNumber)
    val `yield` = calculateYield(winRanks, lottoMoney)
}
