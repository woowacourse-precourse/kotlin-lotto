package domain

import camp.nextstep.edu.missionutils.Randoms
import error.InputError
import error.LottoError
import resource.*

class LottoGame {
    fun run() {
        val purchaseMoney = getPurchaseMoney()
        val numberOfLotto = purchaseMoney / LOTTO_PRICE
        val lottoNumbers = getLottoNumbers(numberOfLotto)
        printLottoNumbers(lottoNumbers)

        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)

        val winningResult = Calculator().calculateWinnings(lottoNumbers, winningNumbers, bonusNumber)
        val winningRate = Calculator().calculateWinningRate(winningResult, purchaseMoney)
        printResult(winningResult, winningRate)
    }
}

fun generateNumbers(): List<Int> {
    val numbers = Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, Number_OF_LOTTO)
    return numbers.sorted()
}

fun getPurchaseMoney(): Int {
    println(INPUT_MONEY)

    val money = readLine()?.trim()
    InputError.checkMoneyValid(money)

    return money!!.toInt()
}

fun getLottoNumbers(num: Int): List<Lotto> {
    val lottos = mutableListOf<Lotto>()

    for (i in 0 until num) {
        lottos.add(Lotto(generateNumbers()))
    }

    return lottos
}

fun getBonusNumber(winnings: List<Int>): Int {
    println("\n$INPUT_BONUS_NUMBER")

    val number = readLine()?.trim()
    InputError.checkIntegerValid(number, winnings)

    return number!!.toInt()
}

fun getWinningNumbers(): List<Int> {
    println("\n$INPUT_NUMBERS")

    val winning = readLine()
    InputError.checkWinningsFormat(winning)

    val winningNumbers = mutableListOf<Int>()
    winning!!.split(SEPARATOR)
        .forEach { num ->
            winningNumbers.add(num.trim().toInt())
        }

    return winningNumbers
}

fun printLottoNumbers(numbers: List<Lotto>) {
    println("\n${numbers.size}$PURCHASE_LOTTO")

    for (number in numbers) {
        number.print()
    }
}

fun printResult(result: List<Int>, rate: Double) {
    println("\n$WINNING_TITLE")
    Winning.printWinnings(result)
    println("총 수익률은 ${rate}%입니다.")
}