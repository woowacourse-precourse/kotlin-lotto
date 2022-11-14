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
    return -1
}

fun checkGrade(numbers:List<Int>,userNum:List<String>,bonus: Int):Int{
    var count = 0
    for(i in 0 until 6) {
        for(j in 0 until 6) {
            if (numbers[i] == userNum[j].toInt()) {
                count++
                break;
            }
        }
    }
    println(count)
    if(count==6) return 1
    else if(count == 5){
        if(bonusSame(numbers,bonus) == 1) return 2
        else return 3
    }
    else if(count == 4) return 4
    else if(count == 3) return 5
    return 0
}

fun pickNum(Num:Int,userNum:List<String>,bonus:Int):Array<Int>{
    var gradeNum = arrayOf(0,0,0,0,0,0)
    for(i in 1 until Num+1){
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(numbers)
    var grade = checkGrade(numbers,userNum,bonus)
        gradeNum[grade]++
    }
    return gradeNum
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
    var gradeNum = pickNum(LottoNum,userNum,bonus)

    println("3개 일치 (5,000원) - ${gradeNum[5]}개")
    println("4개 일치 (50,000원) - ${gradeNum[4]}개")
    println("5개 일치 (1,500,000원) - ${gradeNum[3]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${gradeNum[2]}개")
    println("6개 일치 (2,000,000,000원) - ${gradeNum[1]}개")


}
