package lotto.domain

import camp.nextstep.edu.missionutils.Console
import kotlin.math.pow
import kotlin.math.round

fun main() {
    val paidAmount = askUserMoney()
    val tryNumber = paidAmount / 1000

    val generator = NumberGenerator()
    generator.printLottoList(tryNumber)

    // 당첨 번호와 보너스 번호는 Lotto한테 넘겨야 한다.
    askWinningNumbers()
    askBonusNumber()
}

// 1000원 단위의 구입 금액을 입력 받는다.
fun askUserMoney(): Int {
    println(MONEY_INPUT_MSG)
    val money = Console.readLine().toInt()
    if (money % 1000 != 0) handleException(DIVISION_EXCEPTION_MSG)
    return money
}

// 쉼표로 구분된 당첨 번호를 입력 받아서 정수 리스트를 반환한다.
fun askWinningNumbers(): List<Int> {
    println(WINNING_INPUT_MSG)
    val input = Console.readLine()
    return getWinningNumbers(input)
}

// 쉼표로 구분된 문자열을 정수 리스트로 변환한다.
fun getWinningNumbers(input: String): List<Int> {
    val numbers = mutableListOf<Int>()
    input.split(",").map {
        val item = it.toInt()
        if (item !in 1..45) handleException(RANGE_BOUNDS_EXCEPTION_MSG)
        if (numbers.contains(item)) handleException(DUPLICATE_EXCEPTION_MSG)
        numbers.add(item)
    }
    if (numbers.size != 6) handleException(SIZE_BOUNDS_EXCEPTION_MGS)
    return numbers
}

// 보너스 번호를 입력 받아서 리턴한다.
fun askBonusNumber(): Int {
    println(BONUS_INPUT_MSG)
    val input = Console.readLine().toInt()
    if (input !in 1..45) handleException(DUPLICATE_EXCEPTION_MSG)
    return input
}

// 유저의 잘못된 입력값을 예외 처리한다.
fun handleException(message: String) {
    println(message)
    throw IllegalArgumentException()
}

// 당첨 내역을 출력한다.
fun printWinningList(winners: List<Int>) {
    for (count in winners) {
        println("$WINNER_5_MSG - ${count}개")
        println("$WINNER_4_MSG - ${count}개")
        println("$WINNER_3_MSG - ${count}개")
        println("$WINNER_2_MSG - ${count}개")
        println("$WINNER_1_MSG - ${count}개")
    }
}

// 수익률을 출력한다.
fun printEarningRate(winners: List<Int>, paidAmount: Int) {
    val rate = calcEarningRate(calcEarning(winners), paidAmount)
    println("총 수익률은 ${rate}% 입니다.")
}

// 수익금을 계산한다.
fun calcEarning(winners: List<Int>): Int {
    val money = listOf(5000, 50_000, 1_500_000, 30_000_000, 2_000_000_000)
    var earning = 0
    for (i in winners.indices) {
        earning = money[i] * winners[i]
    }
    return earning
}

// 수익률을 계산한다.
fun calcEarningRate(profits: Int, paidAmount: Int): Double {
    val earningRate = (profits.toDouble() / paidAmount.toDouble()) * 100
    return roundDigit(earningRate, 2)
}

// 소수점 n번째 자리에서 반올림 한 결과를 리턴한다.
fun roundDigit(number: Double, exponent: Int): Double {
    return round(number * (10.0).pow(exponent - 1)) / (10.0).pow(exponent - 1)
}