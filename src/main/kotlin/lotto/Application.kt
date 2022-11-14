package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val LOTTO_PRICE = 1_000
const val PERCENT = 100

fun main() {
    try {
        lottoGame()
    } catch (e: IllegalArgumentException) {

    }
}

fun lottoGame() {
    val lottoCount = generateLottoCount()
    val winningNumbers = generateWinningNumbers()
    val bonusNumber = generateBonusNumber(winningNumbers)
    val lottos = generateLottos(lottoCount)

    for (lotto in lottos) {
        checkLottoWin(lotto, winningNumbers, bonusNumber)
    }
    showResult(lottoCount)
}

fun generateLottoCount(): Int {
    println("구입금액을 입력해 주세요.")
    val money = Console.readLine()
    checkMoneyThrowException(money)
    val lottoCount = money.toInt() / LOTTO_PRICE
    println("${lottoCount}개를 구매했습니다.")
    return lottoCount
}

fun checkMoneyThrowException(userInput: String) {
    throwIsMoneyNumberException(userInput)
    throwMoneyUnitException(userInput)
}

fun throwIsMoneyNumberException(userInput: String) {
    val numbers = userInput.toCharArray().filter { number ->
        number in '0'..'9'
    }
    if (numbers.size != userInput.length) {
        println("[ERROR] 구입 금액은 숫자여야 합니다.")
        throw IllegalArgumentException()
    }
}

fun throwMoneyUnitException(userInput: String) {
    if (userInput.toInt() % LOTTO_PRICE != 0) {
        println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.")
        throw IllegalArgumentException()
    }
}

fun generateWinningNumbers(): Lotto {
    println("당첨 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    val winningNumbers = convertWinningNumbersStringToIntList(userInput)
    return Lotto(winningNumbers)
}

fun convertWinningNumbersStringToIntList(userInput: String): List<Int> {
    throwWinningNumberFormException(userInput)
    return userInput.split(',').map { it.toInt() }
}

fun throwWinningNumberFormException(userInput: String) {
    userInput.forEach { char ->
        if (!(char in '0'..'9' || char == ',')) {
            println("[ERROR] 로또 번호는 숫자와 ,만 입력 해야 합니다.")
            throw IllegalArgumentException()
        }
    }
}

fun generateBonusNumber(winningNumbers: Lotto): Int {
    println("보너스 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    checkBonusNumberThrowException(userInput, winningNumbers)
    return userInput.toInt()
}

fun checkBonusNumberThrowException(userInput: String, winningNumbers: Lotto) {
    throwBonusNumberFormException(userInput)
    throwBonusNumberRangeException(userInput)
    throwBonusNumberDuplicationException(userInput, winningNumbers)
}

fun throwBonusNumberFormException(number: String) {
    number.forEach { char ->
        if (char !in '0'..'9') {
            println("[ERROR] 보너스 번호는 숫자만 입력 해야 합니다.")
            throw IllegalArgumentException()
        }
    }
}

fun throwBonusNumberRangeException(number: String) {
    if (number in "1".."45") {
        println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
        throw IllegalArgumentException()
    }
}

fun throwBonusNumberDuplicationException(number: String, winningNumbers: Lotto) {
    if (winningNumbers.getNumbers().contains(number.toInt())) {
        println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
        throw IllegalArgumentException()
    }
}

fun generateLotto(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers)
}

fun generateLottos(lottoCount: Int): List<Lotto> {
    val lottos = mutableListOf<Lotto>()
    repeat(lottoCount) {
        val lotto = generateLotto()
        lotto.print()
        lottos.add(lotto)
    }
    return lottos
}

fun checkLottoWin(lotto: Lotto, winningNumbers: Lotto, bonusNumber: Int) {
    var count = 0
    lotto.print()
    for (number in lotto.getNumbers()) {
        if (winningNumbers.isContainedNumber(number)) count++
    }

    when {
        count == 3 -> Result.FIFTH.addWinCount()
        count == 4 -> Result.FOURTH.addWinCount()
        count == 5 && !lotto.isContainedNumber(bonusNumber) -> Result.THIRD.addWinCount()
        count == 5 && lotto.isContainedNumber(bonusNumber) -> Result.SECOND.addWinCount()
        count == 6 -> Result.FIRST.addWinCount()
    }
}

fun showResult(lottoCount: Int) {
    println("당첨 통계")
    println("---")

    Result.FIFTH.print()
    Result.FOURTH.print()
    Result.THIRD.print()
    Result.SECOND.print()
    Result.FIRST.print()

    println("총 수익률은 ${calculateEarningsRate(lottoCount)}%입니다.")
}

fun calculateEarningsRate(lottoCount: Int): Double {
    var totalEarning = 0
    listOf(Result.FIFTH, Result.FOURTH, Result.THIRD, Result.SECOND, Result.FIRST).forEach { result ->
        totalEarning += result.getEarningRate()
    }
    return totalEarning / (lottoCount.toDouble() * LOTTO_PRICE) * PERCENT
}
