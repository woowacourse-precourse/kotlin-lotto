package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    //금액설정
    val moneyString:String = "3000"

    //몇장인지 설정
    val buyCount = moneyToCount(moneyString)
    //로또용지생성
    val paper = Array<Lotto>(buyCount){Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))}
    //로또용지출력
    printLotto(paper)

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



