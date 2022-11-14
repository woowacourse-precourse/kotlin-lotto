package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private var one =0
private var two =0
private var three =0
private var four =0
private var five =0
private var stat=0


fun makeRandomNumbers(lottoCount: Int, lotto:MutableList<List<Int>>){
    for(i in 0 until lottoCount){
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6) //로또 번호 랜덤으로 생성
        lotto.add(numbers)
        println(numbers)
    }
}


fun showResult(){

    println("3개 일치 (5,000원) - ${one}개")
    println("4개 일치 (50,000원) - ${two}개")
    println("5개 일치 (1,500,000원) - ${three}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${four}개")
    println("6개 일치 (2,000,000,000원) - ${five}개")
    println("총 수익률은 ${stat}%입니다.")
}

fun lottoWinCheck(lucky:MutableList<List<Int>>,extra:Int){
    println("당첨 통계")
    println("---")
    showResult()


}
fun main() {
    println("구입 금액을 입력하세요")
    val money = Console.readLine()!!.toInt() //정수형 변환
    val lottoCount = money/1000 //로또 횟수

    print("\n")
    println("${lottoCount}개를 구매했습니다. ")

    val lotto= mutableListOf<List<Int>>()//사용자가 구매한 로또(랜덤번호로)
    makeRandomNumbers(lottoCount,lotto)

    println("당첨 번호를 입력해 주세요.")
    val lucky= mutableListOf<List<Int>>()
    val luckyNumbers=Console.readLine()!!.toInt()
    lucky.add(listOf(luckyNumbers))

    println("보너스 번호를 입력해 주세요.")
    val extra=Console.readLine()!!.toInt()
    lottoWinCheck(lucky,extra)

    showResult()



}
