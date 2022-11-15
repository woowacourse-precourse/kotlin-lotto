package lotto

import camp.nextstep.edu.missionutils.Randoms
import error.InputError
import error.LottoError
import lotto.Winning.Companion.formatPrize
import resource.*

fun main() {
    val purchaseMoney = getPurchaseMoney()
    val numberOfLotto = purchaseMoney / LOTTO_PRICE
    val lottoNumbers = getLottoNumbers(numberOfLotto)
    printLottoNumbers(lottoNumbers)

    val winningNumbers = getWinningNumbers()
    val bonusNumber = getBonusNumber(winningNumbers)

    val winningResult = calculateWinnings(lottoNumbers, winningNumbers, bonusNumber)
    val winningRate = calculateWinningRate(winningResult, purchaseMoney)
    printResult(winningResult, winningRate)
}

fun printResult(result: List<Int>, rate: Double) {
    println("\n$WINNING_TITLE")
    println("$WINNING_FIFTH${formatPrize(Winning.FIFTH)} - ${result[Winning.FIFTH.ordinal]}개")
    println("$WINNING_FOURTH${formatPrize(Winning.FOURTH)} - ${result[Winning.FOURTH.ordinal]}개")
    println("$WINNING_THIRD${formatPrize(Winning.THIRD)} - ${result[Winning.THIRD.ordinal]}개")
    println("$WINNING_SECOND${formatPrize(Winning.SECOND)} - ${result[Winning.SECOND.ordinal]}개")
    println("$WINNING_FIRST${formatPrize(Winning.FIRST)} - ${result[Winning.FIRST.ordinal]}개")
    println("총 수익률은 ${rate}%입니다.")
}

fun calculateWinningRate(result: List<Int>, money: Int): Double {
    val sum = Winning.getAllPrize(result)
    val rate = (sum.toDouble() / money.toDouble()) * 100

    return (Math.round(rate * 10)) / 10.0
}

fun calculateWinnings(lottos: List<Lotto>, winnings: Lotto, bonus: Int): List<Int> {
    val result = mutableListOf(0, 0, 0, 0, 0)
    for (lotto in lottos) {
        val prize = lotto.calculateWinnings(winnings, bonus)
        if (prize == -1) {
            continue
        }
        result[prize]++
    }

    return result
}

fun getBonusNumber(winnings: Lotto): Int {
    println("\n$INPUT_BONUS_NUMBER")

    val value = readLine()
    InputError.checkInteger(value)

    val number = value!!.toInt()
    LottoError.checkOutOfRange(number)
    LottoError.checkDuplicate(winnings, number)

    return number
}

fun getWinningNumbers(): Lotto {
    println("\n$INPUT_NUMBERS")

    val winning = readLine()
    InputError.checkWinningsFormat(winning)

    val winningNumbers = mutableListOf<Int>()
    winning!!.split(SEPARATOR)
        .forEach { num ->
            winningNumbers.add(num.trim().toInt())
        }

    return Lotto(winningNumbers)
}

fun printLottoNumbers(numbers: List<Lotto>) {
    println("\n${numbers.size}$PURCHASE_LOTTO")

    for (number in numbers) {
        number.print()
    }
}

fun getLottoNumbers(num: Int): List<Lotto> {
    val lottos = mutableListOf<Lotto>()

    for (i in 0 until num) {
        lottos.add(Lotto(generateNumbers()))
    }

    return lottos
}

fun generateNumbers(): List<Int> {
    val numbers = Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, Number_OF_LOTTO)
    return numbers.sorted()
}

fun getPurchaseMoney(): Int {
    println(INPUT_MONEY)

    val value = readLine()
    InputError.checkInteger(value)

    val money = value!!.toInt()
    InputError.checkValidMoney(money)

    return money
}
