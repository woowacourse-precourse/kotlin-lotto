package lotto
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun checkUserMoney(userMoney:String):Int{
   var userMoney = userMoney.toIntOrNull()
    if(userMoney == null) {
        print("[ERROR] 수를 입력하세요")
        throw IllegalArgumentException()
    }

    if(userMoney%1000 != 0) {
        print("[ERROR] 1000으로 나누어 떨어지는 수를 입력하세요")
        throw IllegalArgumentException()}
    return userMoney
}
fun bonusSame(numbers: List<Int>, bonus: Int):Int{
    for(i in 0 until 6){
        if(numbers[i].toInt() == bonus) return 1
    }
    return 0
}

fun checkGrade(numbers:List<Int>,userNum:List<String>,bonus: Int):Int{
    var count = 0
    for(i in 0 until 6) {
        if(numbers[i] == userNum[i].toInt()) count++
    }
    if(count==6) return 1
    else if(count == 5){
        if(bonusSame(numbers,bonus) == 1) return 2
        else return 3
    }
    else if(count == 4) return 4
    else if(count == 3) return 5
    return 0
}

fun pickNum(Num:Int,userNum:List<String>,bonus:Int){
    var ok = arrayOf(0,0,0,0,0)
    for(i in 1 until Num+1){
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    var grade = checkGrade(numbers,userNum,bonus)
    }
}


fun main() {
   var userMoney = Console.readLine()!!.toString()
    var LottoNum = (checkUserMoney(userMoney))/1000
    println("${LottoNum}개를 구매했습니다.")
    println("당첨번호를 입력하세요")
    val userString = Console.readLine()!!.toString()
    val userNum = userString.split(",")
    println("보너스 점수를 입력하세요")
    var bonus = Console.readLine()!!.toInt()

    pickNum(LottoNum,userNum,bonus)

}
