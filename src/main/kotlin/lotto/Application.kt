package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

val result= Array<Int>(6){0}
fun main() {
    //금액설정
//    val moneyString:String = "3000"
    val moneyString:String = Console.readLine()

    //몇장인지 설정
    val buyCount = moneyToCount(moneyString)
    //로또용지생성
    val paper = Array<Lotto>(buyCount){Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))}
    //로또용지출력
    printLotto(paper)

    println("당첨 번호를 입력해 주세요.")
//    val solution = "1,2,3,4,5,6" //임시 당첨번호
    val solution = Console.readLine()
    val solutionList = mutableListOf<Int>()

    //스플릿하여 리스트에 추가
    solution.split(",").forEach{
        solutionList.add(it.toInt())
    }

    println("보너스 번호를 입력해 주세요.")
    val bonus = 7

    paper.forEach{
        result[it.rank(solutionList,bonus)]++
    }

    printResult(moneyString)

}
fun printResult(moneyString:String){
    println("3개 일치 (5,000원) - ${result[5]}개\n" +
            "4개 일치 (50,000원) - ${result[4]}개\n" +
            "5개 일치 (1,500,000원) - ${result[3]}개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[2]}개\n" +
            "6개 일치 (2,000,000,000원) - ${result[1]}개")
    val buy = moneyString.toInt()
    val now = 5000*result[5] + 50000*result[4] + 1500000*result[3] + 30000000*result[2] + 2000000000*result[1]
    val earn = (now.toDouble()/buy.toDouble())*100
    println("총 수익률은 ${earn}%입니다.")
}
fun printLotto(paper:Array<Lotto>){
    println("${paper.size}개를 구매했습니다.")
    paper.forEach{it.printNumber()}

}
fun moneyToCount(money:String):Int{
    money.forEach{
        isNumber(it)
    }
    isThousand(money.toInt())
    return money.toInt()/1000
}
fun isNumber(c:Char){
    val code = c.code
    if(code<'0'.code || code>'9'.code){
        throw IllegalArgumentException("[ERROR] 금액이 숫자 형태가 아닙니다")
    }
}

fun isThousand(money:Int){
    if(money%1000!=0){
        throw IllegalArgumentException("[ERROR] 금액은 1000 단위로 입력해주세요")
    }
}



