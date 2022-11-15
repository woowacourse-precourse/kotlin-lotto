package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException
import kotlin.IllegalArgumentException

lateinit var consumer: Consumer
var programException = false
lateinit var winningNumbers: Pair<List<Int>, Int>
fun main() {
    programException = false
    orderLotto()
    if (programException) {
        return
    }
    printConsumerLotto()
    winningNumbers = pickWinningNumbers()
    printCompareResult()
}

private fun orderLotto() {
    val money = Console.readLine()
    try {
        consumer = Consumer(money.toInt())
        consumer.buyLotto()
        println("${money.toInt() / WON_THOUSAND_UNIT}개를 구매했습니다.")
    } catch (e: IllegalArgumentException) {
        print(ERROR_INPUT_VALUE)
        programException = true
    }
}

private fun printConsumerLotto() {
    for (lottoCount in consumer.myLotto) {
        println(lottoCount)
    }
}

private fun pickWinningNumbers(): Pair<List<Int>, Int> {
    val inputWinningNumbers = pickWinningLottoList()
    val inputWinningBonusNumber = pickWinningBonusNumber()
    return Pair(inputWinningNumbers, inputWinningBonusNumber)
}

private fun pickWinningLottoList(): List<Int> {
    println(INPUT_LOTTO_NUMBER)
    val inputWinningNumbers = convertStringToIntList(Console.readLine())
    checkLottoListNumberScope(inputWinningNumbers)
    return inputWinningNumbers
}

private fun pickWinningBonusNumber(): Int {
    println(INPUT_BONUS_NUMBER)
    val inputWinningBonusNumber = convertStringToInt(Console.readLine())
    checkLottoNumberScope(inputWinningBonusNumber)
    return inputWinningBonusNumber
}

private fun convertStringToIntList(input: String): List<Int> {
    try {
        return input.split(",")
            .map { it.toInt() }
    } catch (exception: Exception) {
        println(ERROR_INPUT_VALUE)
        throw IllegalArgumentException()
    }
}

private fun convertStringToInt(input: String): Int {
    try {
        return input.toInt()
    } catch (exception: NumberFormatException) {
        println(ERROR_INPUT_VALUE)
        throw IllegalArgumentException()
    }
}

private fun checkLottoListNumberScope(numbers: List<Int>) {
    for (number in numbers) {
        checkLottoNumberScope(number)
    }
}

private fun checkLottoNumberScope(number: Int) {
    if (number > 45 || number < 1) {
        require(false) { println(ERROR_LOTTO_SCOPE) }
    }
}

private fun printCompareResult() {
    val compareLottoResult = compareLotto()
    printWinnings(compareLottoResult)
    printYield(compareLottoResult)
}

private fun compareLotto(): List<Int> {
    return consumer.compareLotto(Lotto(winningNumbers.first), winningNumbers.second)
}

private fun printWinnings(winnings: List<Int>) {
    println("당첨 통계")
    println("---")
    println(Winnings.FIFTH_PLACE.toString(winnings[FIFTH_PLACE_INDEX]))
    println(Winnings.FOURTH_PLACE.toString(winnings[FOURTH_PLACE_INDEX]))
    println(Winnings.THIRD_PLACE.toString(winnings[THIRD_PLACE_INDEX]))
    println(Winnings.SECOND_PLACE.toString(winnings[SECOND_PLACE_INDEX]))
    println(Winnings.FIRST_PLACE.toString(winnings[FIRST_PLACE_INDEX]))
}

private fun printYield(winnings: List<Int>) {
    print("총 수익률은 ${consumer.calculateYield(winnings)}%입니다.")
}