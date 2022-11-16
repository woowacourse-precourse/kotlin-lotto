package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private var lucky = mutableListOf<Int>() //로또 당첨번호
private var bonus =0 //보너스 번호

private var one =0
private var two =0
private var three =0
private var four =0
private var five =0
//private var stat=0


fun makeRandomNumbers(lottoCount: Int, lotto:MutableList<List<Int>>){
    for(i in 0 until lottoCount){
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6) //로또 번호 랜덤으로 생성
        lotto.add(numbers)
        numbers.sort()
        println(numbers)
    }
    println()
}

fun profit(money: Int): Int {
    //수익/투자금액 * 100
    val pro = five*5000 + four*50000 + three*1500000 + two*30000000 + one*2000000000
    return pro / money *100
}


fun lottoWinCheck(lotto: MutableList<List<Int>>, lucky:MutableList<Int>, bonus:Int){

    //사용자가 입력한 로또 번호(+보너스번호)를 luckylist로 매핑
    val luckyList = lotto + lucky
    val map = luckyList.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
    if (map.count() == 3)//5등
        five++
    if (map.count() == 4)//4등
        four++
    if ((map.count() == 5) && !(luckyList.contains(bonus)))//3등
        three++
    if ((map.count() == 5) && (luckyList.contains(bonus)))//2등
        two++
    if (map.count() == 6)//1등
        one++
}

fun inputWinNumber(){

    println("당첨 번호를 입력해 주세요.")
    lucky = Console.readLine().split(",").map { it.toInt() }.toMutableList()
    for(i in 0 until 6) {
        if(lucky[i] < 1 || lucky[i] >45){
            println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            throw(IllegalArgumentException())
    }
    }
    println()

    println("보너스 번호를 입력해 주세요.")
    bonus=Console.readLine()!!.toInt()

}

fun main() {
    println("구입 금액을 입력하세요")
    val money = Console.readLine()!!.toInt() //정수형 변환
    if(money%1000!=0){
        println("[ERROR] 로또 1장의 가격은 1000원입니다. 1000원 단위로 입력해주세요")
        throw IllegalArgumentException()
    }
    val lottoCount = money/1000 //로또 횟수

    print("\n")
    println("${lottoCount}개를 구매했습니다. ")

    val lotto= mutableListOf<List<Int>>()//사용자가 구매한 로또(랜덤번호로)
    makeRandomNumbers(lottoCount,lotto)
    inputWinNumber()
    println("당첨 통계")
    println("---")
    lottoWinCheck(lotto,lucky,bonus) //로또 당첨판 함수
    println("3개 일치 (5,000원) - ${five}개")
    println("4개 일치 (50,000원) - ${four}개")
    println("5개 일치 (1,500,000원) - ${three}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${two}개")
    println("6개 일치 (2,000,000,000원) - ${one}개")

    val stat=profit(money)
    println("총 수익률은 ${stat}%입니다.")
}
