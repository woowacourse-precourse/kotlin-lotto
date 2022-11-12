package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.Exception
import java.util.regex.Pattern
import kotlin.math.*

private const val amount = 1000
fun main() {
    var lottos = mutableListOf<Lotto>()
    var sell = getSellLottoCount()
    var winningNumber: MutableList<Int> = mutableListOf()
    var bonusNumber : Int
    var winningResult = HashMap<String, Int>(5)
    var earningRate : Double

    setLotto(lottos, sell)
    if(sell != 0) {
        getWinningNumber(winningNumber)
        bonusNumber = getBonusNumber(winningNumber)
        getWinningResult(lottos, winningNumber, bonusNumber, winningResult)
        earningRate = getEarningRate(sell, winningResult)
        printWinningResult(winningResult)
        printYieldResult(earningRate)
    }

}
private fun getSellLottoCount() : Int {

    println("구입금액을 입력해 주세요.")

    val input = Console.readLine()!!

    try {
        if (!Pattern.matches("^[0-9]*", input) || (input.toInt() % amount) != 0 || (input.toInt() / amount) == 0) {
            throw IllegalArgumentException("[ERROR] 정확한 로또 금액을 입력해 주세요.")
        }
        else{
            val lottoAmount = input.toInt() / amount
            println("\n${lottoAmount}개를 구매했습니다.")

            return lottoAmount
        }
    } catch (e: IllegalArgumentException){
        println("[ERROR] 정확한 로또 금액을 입력해 주세요.")
        return 0
    }
}

private fun setLotto(lottos : MutableList<Lotto>, count: Int) {

    for(i in 0 until count){
        val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        lottos.add(lotto)
        println(lotto.getLottoNumbers())
    }
}

// 로또 번호 오름차순
private fun getWinningNumber(winningNumber : MutableList<Int>){

    println("\n당첨 번호를 입력해 주세요.")

    val input = Console.readLine()!!

    try {
        if (!Pattern.matches("^[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*\$", input)) {
            throw IllegalArgumentException()
        }
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 공백 없이 입력해 주세요.")
    }

    var checkedNumber : MutableList<Int> = checkWinningNumberInputOvervalueException(checkWinningNumberInputOverlapException(input))
    winningNumber.addAll(checkedNumber)

    //println(winningNumber)
}

private fun checkWinningNumberInputOverlapException(input: String) : MutableSet<String> {

    var str = input.split(',')
    var winningSet : MutableSet<String> = mutableSetOf() // LinkedHashSet 생성: 순서O 중복X

    str.forEach{
        winningSet.add(it)
    }

    if(winningSet.size != 6){
       throw IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.")
    }

    return winningSet
}

private fun checkWinningNumberInputOvervalueException(input : MutableSet<String>) : MutableList<Int> {
    var winningInt : MutableList<Int> = mutableListOf()

    input.forEach {
        val num = it.toInt()
        if(num < 1 || num > 45){
          throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        winningInt.add(num)
    }

    return winningInt
}

// 예외처리 리팩토링 필요
private fun getBonusNumber(winningNumber: MutableList<Int>) : Int {

    println("\n보너스 번호를 입력해 주세요.")

    val input = Console.readLine()!!

    if(!Pattern.matches("^[0-9]*$", input)
        || input.toInt() < 1 || input.toInt() > 45
        || winningNumber.contains(input.toInt())){
        println("[ERROR]")
        //throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

    return input.toInt()
}

private fun getWinningResult(lottos: MutableList<Lotto>, winningNumber: MutableList<Int>, bonusNumber : Int, winningResult : HashMap<String, Int>){
    var threeWin = 0
    var fourWin = 0
    var fiveWin = 0
    var fiveWithBonusWin = 0
    var sixWin = 0

    lottos.forEach {
        when(it.getLottoWinning(winningNumber, bonusNumber)){
            3 -> threeWin++
            4 -> fourWin++
            5 -> fiveWin++
            6 -> sixWin++
            7 -> fiveWithBonusWin++
        }
    }

    winningResult["threeWin"] = threeWin
    winningResult["fourWin"] = fourWin
    winningResult["fiveWin"] = fiveWin
    winningResult["fiveWithBonusWin"] = fiveWithBonusWin
    winningResult["sixWin"] = sixWin

    //println(winningResult)
}

private fun getEarningRate(sell : Int, winningResult: HashMap<String, Int>) : Double {
    // 총 수입
    var earn = 0

    var key = winningResult.filterValues { it != 0 }.keys
    key.forEach{
        earn += getEarnedMoney(it) * winningResult.getValue(it)
    }

    // 수익률
    var a = ((earn.toFloat() / (sell * amount).toFloat()) * 100)
    print("수입: ${earn}, 구입액: ${sell * amount}, 수익: ${earn/(sell*amount)} 수익률: $a")
    return a.toDouble()
}

private fun getEarnedMoney(grade: String) : Int {
    var money = 0

    when(grade){
        "threeWin" -> money = 5000
        "fourWin" -> money = 50000
        "fiveWin" -> money = 1500000
        "sixWin" -> money = 2000000000
        "fiveWithBonusWin" -> money = 30000000
    }
    // ENUM 리팩토링 필요

    return money
}
private fun roundDigit(num : Double, digits : Int) : Double {
    return Math.round(num * Math.pow(10.0, digits.toDouble())) / Math.pow(10.0, digits.toDouble())
}

private fun printWinningResult(winningResult: HashMap<String, Int>){
    println("\n당첨 통계\n---")
    println("3개 일치 (5,000원) - ${winningResult.getValue("threeWin")}개")
    println("4개 일치 (50,000원) - ${winningResult.getValue("fourWin")}개")
    println("5개 일치 (1,500,000원) - ${winningResult.getValue("fiveWin")}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningResult.getValue("fiveWithBonusWin")}개")
    println("6개 일치 (2,000,000,000원) - ${winningResult.getValue("sixWin")}개")
}

private fun printYieldResult(rate : Double){
    println("총 수익률은 ${rate}%입니다.")
}

private fun throwExeption(){
    throw IllegalArgumentException()
}



