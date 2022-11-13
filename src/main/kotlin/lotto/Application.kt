package lotto

import java.lang.Exception


fun main() {

    try {
        var usermoney = moneyinput()
        moneycheck(usermoney)
        var ticket = ticket(usermoney)
        val makelotto = MakeLotto()
        var usernumber = makelotto.userpicknumber(ticket)
        var winningnumber = winningselectnum()
        var bonusnumber = bonusnumber(winningnumber)
        var compare = Compare()
        var point = compare.comparenumber(usernumber, winningnumber, bonusnumber)
        var lotto = Lotto(usernumber[0])
        var propit = lotto.calculater(point)
        var bbbb = profit(usermoney, propit)
        var cccc = '%'
        println(String.format("총 수익률은 %.1f%c입니다.", bbbb, cccc))
    } catch (e: Exception){
    }
}

fun moneyinput () : Int {
    println("구입금액을 입력해 주세요.")
    try{
        var money = readLine()
        var checkmoney = money?.let { isNumber(it) }
        require(checkmoney == true)
//        if (checkmoney == false) {
//            throw IllegalArgumentException("[ERROR]")
//        }
        var moneyoutput = money!!.toInt()
        return moneyoutput
    }catch (e: IllegalArgumentException) {
        println("[ERROR] 숫자만 입력해주세요")
        throw IllegalArgumentException()
    }
}
fun moneycheck (a : Int){
    if (a%1000 != 0)
    {
        throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.")
    }
}
fun ticket(a: Int) : Int
{
    println("${a/1000}개를 구매했습니다.")
    return a/1000
}

// 돈 받기 체크

fun winningselectnum () : IntArray {
    println("당첨 번호를 입력해 주세요.")
    var usernumber = IntArray(6)
    var strinput = readLine()!!.toString()
    var inputslit =strinput.split(",")
    sixnumbererror(inputslit)
    val checkdistinct = inputslit.distinct()
    overlapcheck(checkdistinct)
    for (i in 0..5)
    {
        var inputvalue = inputslit[i].toInt()
        usernumber[i]=inputvalue
    }
    intcheck(usernumber)
    return usernumber
}

//에러 출력
fun sixnumbererror (a:List<String>)
{
    try {
        require(a.size == 6)

    }catch (e: IllegalArgumentException) {
        println("[ERROR] 로또 번호 6개를 맞춰서 입력해주세요")
        throw IllegalArgumentException()
    }

}
fun overlapcheck (a : List<String>)
{
    try {
        require(a.size == 6)
    }catch (e: IllegalArgumentException) {
        println("[ERROR] 번호는 중복 될 수 없습니다.")
        throw IllegalArgumentException()
    }
}
// 보너스 번호 출력
fun bonusnumber (a:IntArray) : Int {
    println("보너스 번호를 입력해 주세요.")
    var bonusnumber = readLine()!!.toInt()
    try {
        for (i in 0..5) {
            require(bonusnumber != a[i]) }
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 기존 번호와 보너스 번호가 같습니다.")
        throw IllegalArgumentException() }
    try {
        require(bonusnumber <= 45 && bonusnumber >= 1)
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 값은 1부터 45까지 입니다.")
        throw IllegalArgumentException() }
    return bonusnumber
}






fun isNumber(s : String): Boolean {
    return when(s.toIntOrNull())
    {
        null -> false
        else -> true
    }
}

fun intcheck (a: IntArray) {
    try{
        for (j in 0..5)
        {
            require(a[j]<=45 && a[j] >= 1)
        }
    }catch (e: IllegalArgumentException) {
        println("[ERROR] 값은 1부터 45까지 입니다.")
        throw IllegalArgumentException() }
}





fun bonuscompare(a:MutableList<List<Int>> , b:IntArray , c:Int , d:Int , e:Int) : Int {
    var bonuscount = 0
    if( c==a[d][e])
    {
        bonuscount +=1
    }
    return bonuscount
}
fun profit (a: Int , b: Int) : Double
{
    var aa = a.toDouble()
    var bb = b.toDouble()
    var result = (bb/aa)*100
    return result
}

fun printwin (a:IntArray)
{
    println("3개 일치 (5,000원) - ${a[0]}개")
    println("4개 일치 (50,000원) - ${a[1]}개")
    println("5개 일치 (1,500,000원) - ${a[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${a[3]}개")
    println("6개 일치 (2,000,000,000원) - ${a[4]}개")
}

//package lotto
//
//import camp.nextstep.edu.missionutils.Randoms
//import java.lang.Exception
//
//lateinit var nums : List<Int>
//
//fun main() {
//    println("구입금액을 입력해 주세요.")
//        val usermoney = moneyinput()
//        moneycheck(usermoney)
//        val ticket = usermoney / 1000
//        println("${ticket}개를 구매했습니다.")
//        val usernumber = userpicknumber(ticket)
//        printusernumber(usernumber)
//        println("당첨 번호를 입력해 주세요.")
//        val winningnumber = winningselectnum()
//        println("보너스 번호를 입력해 주세요.")
//        var bonusnumber = bonusnumber(winningnumber)
//        var pointnumber = comparenumber(usernumber, winningnumber, bonusnumber)
//        var aaaa = calculater(pointnumber)
//        var bbbb = profit(usermoney, aaaa)
//        var cccc = '%'
//        println(String.format("총 수익률은 %.1f%c입니다.", bbbb, cccc))
//}
//
//fun printusernumber (a:MutableList<MutableList<Int>>) {
//    for (i in 0 until a.size)
//    {
//        println("${a[i]}")
//    }
//}
//
//fun userpicknumber (ticket: Int) : MutableList<MutableList<Int>> {
//    val numbers = mutableListOf<MutableList<Int>>()
//    for (i in 0..ticket-1)
//    {
//        val number = Randoms.pickUniqueNumbersInRange(1, 45 ,6)
//        numbers.add(number)
//        val checkdistinct = number.distinct()
//        if (checkdistinct.size != 6)
//        {
//            throw IllegalArgumentException("[Error] 중복된 수 발견")
//        }
//    }
//    return numbers
//}
//
//
//fun isNumber(s : String): Boolean {
//
//    return when(s.toIntOrNull())
//    {
//        null -> false
//        else -> true
//    }
//}
//
//fun moneyinput () : Int {
//    var money = readLine()
//    if(money == null){
//        throw IllegalArgumentException("[ERROR]")
//    }
//    var checkmoney = money?.let { isNumber(it) }
//    if (checkmoney == false) {
//        throw IllegalArgumentException("[ERROR]")
//    }
//    var realmoney = money!!.toInt()
//    return realmoney
//}
//fun moneycheck (a : Int){
//    if (a%1000 != 0)
//    {
//        throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.")
//    }
//}
//
//fun sixnumbererror (a:List<String>)
//{
//    if (a.size != 6)
//    {
//        throw IllegalArgumentException("[ERROR] 로또 번호 6개를 맞춰서 입력해주세요")
//    }
//}
//fun intcheck (a: List<Int>)
//{
//    for (j in 0..5)
//    {
//        if (a[j] > 45 || a[j] < 1)
//        {
//            throw IllegalArgumentException("[ERROR] 값은 1부터 45까지 입니다.")
//        }
//    }
//}
//
//fun overlapcheck (a : List<String>)
//{
//    if (a.size < 6)
//    {
//        throw IllegalArgumentException("[ERROR] 중복된 수 발견")
//    }
//}
//
//
//fun winningselectnum () : List<Int>
//{
//    var usernumber = mutableListOf<Int>()
//    var strinput = readLine()!!.toString()
//    var inputslit =strinput.split(",")
//    sixnumbererror(inputslit)
//    val checkdistinct = inputslit.distinct()
//    overlapcheck(checkdistinct)
//    for (i in 0..5)
//    {
//        var inputvalue = inputslit[i].toInt()
//        usernumber[i]=inputvalue
//    }
//    intcheck(usernumber)
//    return usernumber
//}
//
//fun bonusnumber (a:List<Int>) : Int
//{
//    var bonusnumber = readLine()!!.toInt()
//    for (i in 0..5)
//    {
//        if (bonusnumber == a[i])
//        {
//            throw IllegalArgumentException("[ERROR] 기존 번호와 보너스 번호가 같습니다.")
//        }
//    }
//    if (bonusnumber > 45 || bonusnumber < 1)
//    {
//        throw IllegalArgumentException("[ERROR] 값은 1부터 45까지 입니다.")
//    }
//    return bonusnumber
//}
//
//fun comparenumber1(a:MutableList<MutableList<Int>> , b:List<Int> , c:Int , d:Int , e:Int) : Int {
//    var firstcount = 0
//    if (b[0] == a[d][e])
//    {
//        firstcount+=1
//    }
//    if (b[1] == a[d][e])
//    {
//        firstcount+=1
//    }
//    if (b[2] == a[d][e])
//    {
//        firstcount+=1
//    }
//    return firstcount
//}
//
//fun comparenumber2(a:MutableList<MutableList<Int>> , b:List<Int> , c:Int , d:Int , e:Int) : Int {
//    var secondcount = 0
//    if (b[3] == a[d][e])
//    {
//        secondcount+=1
//    }
//    if (b[4] == a[d][e])
//    {
//        secondcount+=1
//    }
//    if (b[5] == a[d][e])
//    {
//        secondcount+=1
//    }
//    return secondcount
//}
//
//fun bonuscompare(a:MutableList<MutableList<Int>> , b:List<Int> , c:Int , d:Int , e:Int) : Int {
//    var bonuscount = 0
//    if( c==a[d][e])
//    {
//        bonuscount +=1
//    }
//    return bonuscount
//}
//
//
//fun comparenumber(a:MutableList<MutableList<Int>> , b:List<Int> , c:Int) : IntArray {
//    var countunion = IntArray(a.size)
//    var bcp = 0
//    for (i in 0..a.size-1) {
//        var cpn1 = mutableListOf<Int>()
//        var cpn2 = mutableListOf<Int>()
//        for (j in 0..5) {
//            cpn1.add(comparenumber1(a,b,c,i,j))
//            cpn2.add(comparenumber2(a,b,c,i,j))
//            bcp = bonuscompare(a,b,c,i,j) }
//        countunion[i]+=cpn1.sum()
//        countunion[i]+=cpn2.sum()
//        if (bcp > 0 && countunion[i] == 5) {
//            countunion[i]+=10
//        } }
//    return countunion }
//
//fun calculater (a:IntArray) : Int {
//    var money = 0
//    var rank = IntArray(5,)
//    for(item in a){ when(item){
//        3 -> { rank[0] += 1
//            money+=5000 }
//        4 -> { rank[1] += 1
//            money+=50000 }
//        5 -> { rank[2] += 1
//            money+=1500000 }
//        6 -> { rank[4] += 1
//            money+=30000000 }
//        15 -> { rank[3] += 1
//            money+=2000000000 } } }
//    printwin(rank)
//    return money }
//
//
//fun printwin (a:IntArray)
//{
//    println("3개 일치 (5,000원) - ${a[0]}개")
//    println("4개 일치 (50,000원) - ${a[1]}개")
//    println("5개 일치 (1,500,000원) - ${a[2]}개")
//    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${a[3]}개")
//    println("6개 일치 (2,000,000,000원) - ${a[4]}개")
//}
//
//fun profit (a: Int , b: Int) : Double
//{
//    var aa = a.toDouble()
//    var bb = b.toDouble()
//    var result = (bb/aa)*100
//    return result
//}
//

