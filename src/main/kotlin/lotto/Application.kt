package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.StringBuilder
import kotlin.math.round

fun calculateYield(winRanks: Map<LottoRank, Int>, lottoMoney: Int): Float {
    var winMoney = 0f
    for ((k, v) in winRanks) {
        winMoney += k.value * v
    }
    return round((winMoney / (lottoMoney * 1000) * 1000)) / 10
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
    val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.")
    if (bonusNumber < 1 || bonusNumber > 45)
        throw IllegalArgumentException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.")
    return bonusNumber
}

fun getInputWinNumbers(): List<Int> {
    val input = Console.readLine().split(",")

    if (input.size != 6)
        throw IllegalArgumentException("로또 번호는 6개만 입력되어야 합니다.")

    val winNumbers = input.map {
        val number = it.toIntOrNull() ?: throw IllegalArgumentException("로또 번호는 숫자여야 합니다.")
        if (number < 1 || number > 45)
            throw IllegalArgumentException("로또 번호는 1에서 45 사이의 숫자여야 합니다.")
        number
    }

    return winNumbers
}

fun getInputLottoMoney(): Int {
    val input = Console.readLine()
    val lottoMoney = input.toIntOrNull() ?: throw IllegalArgumentException("구매 금액은 숫자로만 이루어져야 합니다.")

    if (lottoMoney % 1000 != 0)
        throw IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.")

    return lottoMoney / 1000
}

fun formatLottos(lottos: List<Lotto>): String {
    val formattedLottos = StringBuilder()
    for (i in lottos) {
        formattedLottos.append(i.toString() + "\n")
    }
    return formattedLottos.toString()
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
    return "총 수익률은 $`yield`%입니다."
}

fun main() {
    try {
        println("구입금액을 입력해 주세요.")
        val lottoMoney = getInputLottoMoney()

        println("${lottoMoney}개를 구매했습니다.")
        val lottos = produceLotto(lottoMoney)
        println(formatLottos(lottos))

        println("당첨 번호를 입력해 주세요.")
        val winNumber = getInputWinNumbers()

        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = getInputBonusNumber()

        println("당첨 통계\n---")
        val winRanks = calculateWinRanks(lottos, winNumber, bonusNumber)
        println(formatWinRanks(winRanks))

        val `yield` = calculateYield(winRanks, lottoMoney)
        println(formatYield(`yield`))
    } catch (e: IllegalArgumentException) {
        println("[ERROR] " + e.message)
    }
}
