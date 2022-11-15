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
        var bnumber = BonusNumber()
        var Bonusnumber = bnumber.bonusnumber(winningnumber)
        var compare = Compare()
        var point = compare.comparenumber(usernumber, winningnumber, Bonusnumber)
        var lotto = Lotto(usernumber[0])
        var propit = lotto.calculater(point)
        var propitpercent = profit(usermoney, propit)
        println(String.format("총 수익률은 %.1f%" + "%입니다.", propitpercent))
    } catch (e: Exception){
    }
}

fun moneyinput () : Int {
    println("구입금액을 입력해 주세요.")
    try{
        var money = readLine()
        var checkmoney = money?.let { isNumber(it) }
        require(checkmoney == true)

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


