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


fun pickNum(Num:Int,userNum:List<String>){
    var ok = arrayOf(0,0,0,0,0)
    for(i in 1 until Num+1){
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    var grade = checkGrade(numbers,userNum);
    ok[grade]++
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

    pickNum(LottoNum,userNum)

}
