package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.Math.round

val set = mutableSetOf<Int>()
fun main() {
    //TODO("프로그램 구현")
    playLotto()

}
fun playLotto(){
    println("구입 금액을 입력해주세요.")
    val count = inputUserMoney()

    println("${count}개를 구매했습니다.")
    val lottoNum = printLottoNumber(count)

    println("당첨번호를 입력해주세요.")
    val userNumber = inputUserNumber()

    println("보너스 번호를 입력해주세요.")
    val userBonusNumber = inputUserBonusNumber()

    val result = checkMatch(userNumber, lottoNum)
    val lottoResult = compareBonus(userBonusNumber, lottoNum, result)
    printResult(lottoResult)
    calProfit(lottoResult, count*1000)
}
fun inputUserMoney():Int{
    val userMoney = Console.readLine().toInt()
    if (userMoney % 1000 != 0){
        throw IllegalArgumentException("[ERROR] 구매 금액이 올바르지 않습니다.")
    }
    return userMoney/1000
}

fun printLottoNumber(count: Int): List<List<Int>>{
    val LottoNum = mutableListOf<List<Int>>()
    for(i in 0..count){
        LottoNum[i] = issueLottoNumber()
    }
    return LottoNum
}
fun issueLottoNumber(): List<Int> {
    val numbers = (Randoms.pickUniqueNumbersInRange(1, 45, 6))
    for (i in 0..5){
        set.add(numbers[i])
    }
    println(numbers)
    return set.toList()
}
fun inputUserNumber(): List<Int> {
    val userNumber = Console.readLine().toInt()
    val userNumberList = mutableListOf<Int>()
    println(userNumberList)
    return userNumberList
}
fun inputUserBonusNumber():Int{
    var userBonusNumber = Console.readLine().toInt()
    println(userBonusNumber)
    return userBonusNumber
}

fun compareBonus(bonusNum: Int, lottoNum: List<List<Int>>, result:Array<Int>):List<Int>{
    var lottoResult = result.toMutableList()
    if(bonusNum == null){
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    if(bonusNum > 45 || bonusNum < 1){
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    for(i in 1..6){
        if(lottoNum[i].contains(bonusNum)){
            lottoResult[3]+=1
        }
    }
    return lottoResult
}

fun checkMatch(userNumber: List<Int>, lottoNum: List<List<Int>>): Array<Int>{
    val result = Array(6){0}
    for(i in lottoNum.indices){
        if(lottoNum[i].contains(userNumber[i])){
            result[i]+=1
        }
    }
    return result
}

fun printResult(result: List<Int>){
    println("당첨 통계")
    println("3개 일치 (5,000원) - ${result[0]}개")
    println("4개 일치 (50,000원) - ${result[1]}개")
    println("5개 일치 (1,500,000원) - ${result[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[3]}개")
    println("6개 일치 (2,000,000,000원) - ${result[4]}개")
}

fun calProfit(result: List<Int>, userMoney: Int){
    var total = (result[0]*5000 + result[1]*50000 + result[2]*1500000 + result[3]*30000000 + result[4]*2000000000)
    var toPercent = total.toDouble() / userMoney.toDouble() * 100.0
    var profit = round(toPercent*10)/10
    println("총 수익률은 ${profit}%입니다.")
}