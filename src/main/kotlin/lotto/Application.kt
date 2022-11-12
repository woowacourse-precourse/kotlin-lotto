package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException
import kotlin.IllegalArgumentException

lateinit var consumer: Consumer
lateinit var lottoCalculator: LottoCalculator
var programException = false
fun main() {
    orderLotto()
    if (programException) {
        return
    }
    printConsumerLotto()
    pickWinningNumbers()
}

private fun orderLotto() {
    val money = Console.readLine()
    try {
        consumer = Consumer(money.toInt())
        consumer.buyLotto()
        println("${money.toInt() / 1000}개를 구매했습니다.")
    } catch (e: IllegalArgumentException) {
        print("[ERROR] " + e.message)
        programException = true
    }
}

private fun printConsumerLotto() {
    for (lottoCount in consumer.myLotto) {
        println(lottoCount)
    }
}

private fun pickWinningNumbers() {
    println("당첨 번호를 입력해 주세요.")
    val inputWinningNumbers = convertStringToIntList(Console.readLine())
    println("\n보너스 번호를 입력해 주세요.")
    val inputWinningBonusNumber = convertStringToInt(Console.readLine())
    lottoCalculator = LottoCalculator(
        consumer.myLotto,
        inputWinningNumbers,
        inputWinningBonusNumber
    )
}

private fun convertStringToIntList(input: String): List<Int> {
    try {
        return input.split(",")
            .map { it.toInt() }
    } catch (exception: Exception) {
        println("[ERROR] 입력값이 올바르지 않습니다.")
        throw IllegalArgumentException()
    }
}

private fun convertStringToInt(input: String): Int {
    try {
        return input.toInt()
    } catch (exception: NumberFormatException) {
        println("[ERROR] 입력값이 올바르지 않습니다.")
        throw IllegalArgumentException()
    }
}