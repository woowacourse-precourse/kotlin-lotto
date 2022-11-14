package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.*
import lotto.utils.*
import kotlin.math.*

fun main() {
    val paidAmount = askUserMoney()
    val tryNumber = paidAmount / MONEY_UNIT
    val lottoNumbers = getLottoNumbers(tryNumber)

    val winningNumbers = askWinningNumbers()
    val bonusNumber = askBonusNumber()

    val lotto = Lotto(winningNumbers)
    val winners = lotto.getWinnerList(lottoNumbers, bonusNumber)

    printWinnerList(winners)
    printEarningRate(winners, paidAmount)
}

// 1000원 단위의 구입 금액을 입력 받는다.
fun askUserMoney(): Int {
    println(MONEY_INPUT_MSG)
    val money = Console.readLine()
    return getUserMoney(money)
}

fun getUserMoney(money: String): Int {
    for(item in money){
        if(!Character.isDigit(item)) handleException(MIXED_CHAR_ERROR_MSG)
    }
    if (money.toInt() % MONEY_UNIT != 0) handleException(DIVISION_ERROR_MSG)
    return money.toInt()
}

// 발행한 로또 수량 및 번호를 출력한다. (로또 번호는 오름차순 정렬)
fun getLottoNumbers(tryNumber: Int): List<List<Int>> {
    println("\n${tryNumber}개를 구매했습니다.")
    val generator = NumberGenerator()
    val lottoNumbers = mutableListOf<List<Int>>()
    for(i in 0 until tryNumber){
        val lottoNumber = generator.createLottoNumbers()
        lottoNumbers.add(lottoNumber)
        println(lottoNumber)
    }
    return lottoNumbers
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
        for(item in it){
            if(!Character.isDigit(item))
                handleException(MIXED_CHAR_ERROR_MSG)
        }
        val ele = it.toInt()
        if (ele !in MIN_VALUE..MAX_VALUE) handleException(RANGE_BOUNDS_ERROR_MSG)
        if (numbers.contains(ele)) handleException(DUPLICATE_ERROR_MSG)
        numbers.add(ele)
    }
    if (numbers.size != LOTTO_NUM_LIMIT) handleException(SIZE_BOUNDS_ERROR_MSG)
    return numbers
}

// 보너스 번호를 입력 받아서 리턴한다.
fun askBonusNumber(): Int {
    println(BONUS_INPUT_MSG)
    val input = Console.readLine()
    return getBonusNumber(input)
}

fun getBonusNumber(input: String): Int {
    for(item in input){
        if(!Character.isDigit(item)) handleException(MIXED_CHAR_ERROR_MSG)
    }
    if (input.toInt() !in MIN_VALUE..MAX_VALUE)
        handleException(RANGE_BOUNDS_ERROR_MSG)
    return input.toInt()
}

// 유저의 잘못된 입력값을 예외 처리한다.
fun handleException(message: String) {
//    println(message)
    throw IllegalArgumentException(message)
}

// 당첨 내역을 출력한다.
fun printWinnerList(winners: List<Int>) {
    println(WINNER_RESULT_MGS)
    println("$WINNER_5_MSG - ${winners[0]}개")
    println("$WINNER_4_MSG - ${winners[1]}개")
    println("$WINNER_3_MSG - ${winners[2]}개")
    println("$WINNER_2_MSG - ${winners[3]}개")
    println("$WINNER_1_MSG - ${winners[4]}개")
}

// 수익률을 출력한다.
fun printEarningRate(winners: List<Int>, paidAmount: Int) {
    val profits = calcProfits(winners)
    val earningRate = calcEarningRate(profits, paidAmount)
    println("총 수익률은 ${earningRate}%입니다.")
}

// 수익금을 계산한다.
fun calcProfits(winners: List<Int>): Int {
    val money = listOf(5000, 50_000, 1_500_000, 30_000_000, 2_000_000_000)
    var profits = 0
    for (i in winners.indices) {
        profits += money[i] * winners[i]
    }
    return profits
}

// 수익률을 계산한다.
fun calcEarningRate(profits: Int, paidAmount: Int): Double {
    val earningRate = (profits.toDouble() / paidAmount.toDouble()) * 100
    return roundDigit(earningRate, ROUND_CRITERIA)
}

// 소수점 n번째 자리에서 반올림 한 결과를 리턴한다.
fun roundDigit(number: Double, exponent: Int): Double {
    return round(number * (10.0).pow(exponent - 1)) / (10.0).pow(exponent - 1)
}
