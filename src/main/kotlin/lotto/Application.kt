package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

fun main() {
    println("구입금액을 입력해 주세요.")
    val money = Console.readLine().checkMoneyException()
    val lottoList = getLottoList(money)
    lottoList.forEach { it.printLotto() }
    println("당첨 번호를 입력해 주세요.")
    val winningNumber = checkWinningNumberException(Console.readLine().split(","))
    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = Console.readLine().checkLottoNumberException()
    checkWinningAndBonusNumberException(winningNumber, bonusNumber)
    val resultMap = totalLottoResult(lottoList, winningNumber, bonusNumber)
    resultMap.printTotalResult()
    calculateRevenue(money, resultMap.totalPrice())
}

fun makeLotto(): Lotto = try {
    Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
} catch (e: IllegalArgumentException) {
    makeLotto()
}

fun getLottoList(money: Int): List<Lotto> {
    val lottoList = mutableListOf<Lotto>()
    println("${money / 1000}개를 구매했습니다.")
    for (i in 0 until (money / 1000)) {
        lottoList.add(makeLotto())
    }
    return lottoList
}

fun printAndThrowIllegalException(errorMessage: String) {
    println(errorMessage)
    throw IllegalArgumentException(errorMessage)
}

fun String.checkMoneyException(): Int {
    try {
        if (this.toInt() % 1000 != 0) {
            printAndThrowIllegalException("[ERROR] 구입 금액을 잘못입력하셨습니다.")
        }
    } catch (e: NumberFormatException) {
        printAndThrowIllegalException("[ERROR] 구입 금액을 잘못입력하셨습니다.")
    }
    return this.toInt()
}

fun String.checkLottoNumberException(): Int {
    try {
        if (this.toInt() <= 0 || this.toInt() > 45) {
            printAndThrowIllegalException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    } catch (e: NumberFormatException) {
        printAndThrowIllegalException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    return this.toInt()
}

fun checkWinningNumberException(winningNumber: List<String>): List<Int> {
    try {
        Lotto(winningNumber.map { it.checkLottoNumberException() })
    } catch (e: IllegalArgumentException) {
        printAndThrowIllegalException("[ERROR] 당첨 번호의 개수가 잘못 입력되었거나 중복되었습니다.")
    }
    return winningNumber.map { it.checkLottoNumberException() }
}

fun checkWinningAndBonusNumberException(winningNumber: List<Int>, bonusNumber: Int) {
    if (winningNumber.contains(bonusNumber)) printAndThrowIllegalException("[ERROR] 보너스 번호가 당첨 번호와 중복되었습니다.")
}

fun totalLottoResult(lottoList: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int): Map<LottoResult, Int> {
    val resultMap = getLottoResultMapInit().toMutableMap()
    lottoList.forEach { lotto ->
        val result = lotto.getResult(winningNumber, bonusNumber)
        resultMap[result] = (resultMap[result] ?: 0) + 1
    }
    return resultMap
}

fun getLottoResultMapInit(): Map<LottoResult, Int> {
    val resultMap = HashMap<LottoResult, Int>()
    resultMap[LottoResult.First] = 0
    resultMap[LottoResult.Second] = 0
    resultMap[LottoResult.Third] = 0
    resultMap[LottoResult.Fourth] = 0
    resultMap[LottoResult.Fifth] = 0
    return resultMap
}

fun Map<LottoResult, Int>.printTotalResult() {
    this.toList().sortedBy { it.first.price }.forEach {
        if (it.first != LottoResult.None) {
            println("${it.first.description} - ${it.second}개")
        }
    }
}

fun Map<LottoResult, Int>.totalPrice(): Long {
    var totalPrice = 0L
    this.forEach {
        totalPrice += it.key.price * it.value
    }
    return totalPrice
}

fun calculateRevenue(money: Int, price: Long) {
    println("총 수익률은 ${round(price.toDouble() * 1000 / money) / 10}%입니다.")
}