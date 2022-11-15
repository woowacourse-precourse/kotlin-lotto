package lotto
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.*


enum class Grade(val money:Int){
    First(2000000000),
    Second(30000000),
    Third(1500000),
    Fourth(50000),
    Fifth(5000);
}

class Money{
    fun checkUserMoney(userMoney:String):Int{
        var userMoney = userMoney.toIntOrNull()
        if(userMoney == null) {
            throw IllegalArgumentException("[ERROR] 숫자를 입력해주세요")
        }
        if(userMoney%1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 수를 입력해주세요")}
        return userMoney
    }
}

fun bonusSame(numbers: List<Int>, bonus: Int):Int{
    for(i in 0 until 6){
        if(numbers[i].toInt() == bonus) return 1
    }
    return -1
}

fun checkSame(one:Int,two:Int,count:Int):Int{
    if(one == two) return count+1
    return count
}

fun checkGrade(numbers:List<Int>,userNum:List<Int>,bonus: Int):Int{
    var count = 0
    for(i in 0 until 6) {
        for(j in 0 until 6) {
            count = checkSame(numbers[i],userNum[j],count)
        }
    }
    println(count)
    return returnGrade(numbers,bonus,count)
}

fun returnGrade(numbers:List<Int>,bonus: Int,count: Int):Int{
    if(count==6) return 1
    else if(count == 5){
        if(bonusSame(numbers,bonus) == 1) return 2
        else return 3
    }
    else if(count == 4) return 4
    else if(count == 3) return 5
    return 0
}

fun pickNum(Num:Int,userNum:List<Int>,bonus:Int):Array<Int>{
    var gradeNum = arrayOf(0,0,0,0,0,0)
    for(i in 1 until Num+1){
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(numbers)
    var grade = checkGrade(numbers,userNum,bonus)
        gradeNum[grade]++
    }
    return gradeNum
}

fun printGrade(gradeNum : Array<Int>){
    println("3개 일치 (5,000원) - ${gradeNum[5]}개")
    println("4개 일치 (50,000원) - ${gradeNum[4]}개")
    println("5개 일치 (1,500,000원) - ${gradeNum[3]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${gradeNum[2]}개")
    println("6개 일치 (2,000,000,000원) - ${gradeNum[1]}개")
}

fun userNum(lottoNum:Int){
    println("${lottoNum}개를 구매했습니다.")
    println("당첨번호를 입력하세요")
    val userString = Console.readLine()!!.toString()
    val userNum = userString.split(",")
    if(userNum.size!=6) throw IllegalArgumentException()
    val userNumInt :List<Int> = arrayListOf(userNum[0].toInt(),userNum[1].toInt(),userNum[2].toInt(),userNum[3].toInt(),userNum[4].toInt(),userNum[5].toInt())
    val ok = Lotto(userNumInt)
    println("보너스 점수를 입력하세요")
    var bonus = Console.readLine()!!.toInt()
    Bonus(userNumInt,bonus)
    var gradeNum = pickNum(lottoNum,userNumInt,bonus)
    EarnMoneyPersent(gradeNum,lottoNum)
}

fun checkEarnMoney(gradeNum: Array<Int>):Double{
    var plusMoney : Double= 0.0
    if(gradeNum[1] != 0) plusMoney+=Grade.First.money*gradeNum[1]
    if(gradeNum[2] != 0) plusMoney+=Grade.Second.money*gradeNum[2]
    if(gradeNum[3] != 0) plusMoney+=Grade.Third.money*gradeNum[3]
    if(gradeNum[4] != 0) plusMoney+=Grade.Fourth.money*gradeNum[4]
    if(gradeNum[5] != 0) plusMoney+=Grade.Fifth.money*gradeNum[5]
    return plusMoney
}

fun EarnMoneyPersent(gradeNum: Array<Int>,lottoNum: Int){
    printGrade(gradeNum)
    var plusMoney = checkEarnMoney(gradeNum)
    var earnMoney : Double = (plusMoney/(lottoNum*1000.0))*100.0
    var earnMoneyRound = Math.ceil(earnMoney*10)/10.0
    println("총 수익률은 ${earnMoney}%입니다.")
}

fun main() {
    var userMoney = Console.readLine()!!.toString()
    val money = Money()

    try{
    var checkUserMoneyOk = money.checkUserMoney(userMoney)}
    catch(e:IllegalArgumentException){
        println("[ERROR] 잘못 입력하셨습니다.")
        return
    }

    var checkUserMoneyOk = money.checkUserMoney(userMoney)
    var lottoNum = (checkUserMoneyOk)/1000

    userNum(lottoNum)
}
