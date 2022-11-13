package lotto.domain

import camp.nextstep.edu.missionutils.Console
import kotlin.math.pow
import kotlin.math.round

fun main() {
    val paid = askUserMoney()
    val tryNumber = paid / 1000
    println("${tryNumber}를 구매했습니다.")

//    for(i in 0 until tryNumber){
//        val lottoNumbers = NumberGenerator().createLottoNumbers()
//        println(lottoNumbers)
//    }
//
//    for(i in 0 until tryNumber){
//        val winningNumbers = askWinningNumbers()
//        val bonusNumber = askBonusNumber()
//
//        val lotto = Lotto(lottoNumbers)
//        val winners = lotto.compare(winningNumbers)
//        printResult(winners, paid)
//    }
}

// 1000원 단위의 구입 금액을 입력 받는다.
fun askUserMoney(): Int {
    println("구입 금액을 입력해주세요.")
    val money = Console.readLine().toInt()
    if(money % 1000 != 0) handleException("[ERROR] 1000원 단위의 금액만 입력해주세요.")
    return money
}

// 쉼표로 구분된 당첨 번호를 입력 받는다.
fun askWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해주세요.")
    val numbers = mutableListOf<Int>()

    Console.readLine().split(",").map {
        val item = it.toInt()
        if(item !in 1..45) handleException("[ERROR] 1부터 45 사이의 숫자만 입력해주세요.")
        if(numbers.contains(item)) handleException("[ERROR] 중복되지 않는 숫자를 입력해주세요.")
        numbers.add(item)
    }
    if(numbers.size != 6) handleException("[ERROR] 당첨 번호는 6개여야 합니다.")

    return numbers
}

// 보너스 번호를 입력 받는다.
fun askBonusNumber(): Int {
    println("보너스 번호를 입력해주세요.")
    val input = Console.readLine().toInt()
    if(input !in 1..45) handleException("[ERROR] 1부터 45 사이의 숫자만 입력해주세요.")
    return input
}

fun handleException(message: String){
    println(message)
    throw IllegalArgumentException()
}

// 당첨 내역과 수익률을 출력한다.
fun printResult(winners: List<Int>, paid: Int) {
    for(count in winners){
        println("3개 일치 (5,000원) - ${count}개")
        println("4개 일치 (50,000원) - ${count}개")
        println("5개 일치 (1,500,000원) - ${count}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${count}개")
        println("6개 일치 (2,000,000,000원) - ${count}개")
    }
    val rate = calcEarningRate(calcEarning(winners), paid)
    println("총 수익률은 ${rate}% 입니다.")
}

// 수익금을 계산한다.
fun calcEarning(winners: List<Int>): Int {
    val money = listOf(5000, 50_000, 1_500_000, 30_000_000, 2_000_000_000)
    var earning = 0
    for(i in winners.indices){
        earning = money[i] * winners[i]
    }
    return earning
}

// 수익률을 계산한다.
fun calcEarningRate(earning: Int, paid: Int): Double {
    val rate = (earning / paid) * 100
    val temp = (10.0).pow(2-1)
    return round(rate * temp) / temp
}