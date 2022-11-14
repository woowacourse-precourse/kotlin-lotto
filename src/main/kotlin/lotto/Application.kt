package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException
import kotlin.IllegalArgumentException

lateinit var consumer: Consumer
var programException = false
lateinit var winningNumbers : Pair<List<Int>,Int>
fun main() {
    programException=false
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

private fun pickWinningNumbers() :Pair<List<Int>,Int> {
    println("당첨 번호를 입력해 주세요.")
    val inputWinningNumbers = convertStringToIntList(Console.readLine())
    println("\n보너스 번호를 입력해 주세요.")
    val inputWinningBonusNumber = convertStringToInt(Console.readLine())
    return Pair(inputWinningNumbers,inputWinningBonusNumber)
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

private fun printCompareResult(){
    val compareLottoResult = compareLotto()
    printWinnings(compareLottoResult)
    printYield(compareLottoResult)
}

private fun compareLotto() : List<Int>{
    return consumer.compareLotto(Lotto(winningNumbers.first), winningNumbers.second)
}

private fun printWinnings(winnings : List<Int>){
    println("당첨 통계")
    println("---")
    println(Winnings.FIFTH_PLACE.toString(winnings[FIFTH_PLACE_INDEX]))
    println(Winnings.FOURTH_PLACE.toString(winnings[FOURTH_PLACE_INDEX]))
    println(Winnings.THIRD_PLACE.toString(winnings[THIRD_PLACE_INDEX]))
    println(Winnings.SECOND_PLACE.toString(winnings[SECOND_PLACE_INDEX]))
    println(Winnings.FIRST_PLACE.toString(winnings[FIRST_PLACE_INDEX]))
}

private fun printYield(winnings: List<Int>){
    print("총 수익률은 ${consumer.calculateYield(winnings)}%입니다.")
}