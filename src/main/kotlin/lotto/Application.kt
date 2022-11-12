package lotto

import camp.nextstep.edu.missionutils.Randoms
import org.mockito.internal.matchers.Null
import kotlin.math.roundToInt
import camp.nextstep.edu.missionutils.test.NsTest
import java.lang.Exception


fun main() {
    println("구입금액을 입력해 주세요.")
    try {
        var usermoney = moneyinput()
        moneycheck(usermoney)
        var ticket = usermoney / 1000
        println("${ticket}개를 구매했습니다.")
        var usernumber = userpicknumber(ticket)
        printusernumber(usernumber)
        println("당첨 번호를 입력해 주세요.")
        var winningnumber = winningselectnum()
        println("보너스 번호를 입력해 주세요.")
        var bonusnumber = bonusnumber(winningnumber)
        var pointnumber = comparenumber(usernumber, winningnumber, bonusnumber)
        var aaaa = calculater(pointnumber)
        var bbbb = profit(usermoney, aaaa)
        var cccc = '%'
        System.out.println(String.format("총 수익률은 %.1f%c입니다.", bbbb, cccc))
    } catch (e: Exception){
        print("[ERROR]")
    }
}

fun printusernumber (a:MutableList<MutableList<Int>>) {
    for (i in 0 until a.size)
    {
        println("${a[i]}")
    }
}

fun userpicknumber (ticket: Int) : MutableList<MutableList<Int>> {
    val numbers = mutableListOf<MutableList<Int>>()
    for (i in 0..ticket-1)
    {
        val number = Randoms.pickUniqueNumbersInRange(1, 45 ,6)
        numbers.add(number)
        val checkdistinct = number.distinct()
        if (checkdistinct.size != 6)
        {
            throw IllegalArgumentException("[Error] 중복된 수 발견")
        }
    }
    return numbers
}


fun isNumber(s : String): Boolean {

    return when(s.toIntOrNull())
    {
        null -> false
        else -> true
    }
}

fun moneyinput () : Int {
    var money = readLine()

    var checkmoney = money?.let { isNumber(it) }

    if (checkmoney == false) {
        throw IllegalArgumentException("[ERROR]")
    }
    var realmoney = money!!.toInt()

    return realmoney
}
fun moneycheck (a : Int){
    if (a%1000 != 0)
    {
        throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.")
    }
}

fun sixnumbererror (a:List<String>)
{
    if (a.size != 6)
    {
        throw IllegalArgumentException("[ERROR] 로또 번호 6개를 맞춰서 입력해주세요")
    }
}
fun intcheck (a: IntArray)
{
    for (j in 0..5)
    {
        if (a[j] > 45 || a[j] < 1)
        {
            throw IllegalArgumentException("[ERROR] 값은 1부터 45까지 입니다.")
        }
    }
}

fun overlapcheck (a : List<String>)
{
    if (a.size < 6)
    {
        throw IllegalArgumentException("[ERROR] 중복된 수 발견")
    }
}


fun winningselectnum () : IntArray
{
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

fun bonusnumber (a:IntArray) : Int
{
    var bonusnumber = readLine()!!.toInt()
    for (i in 0..5)
    {
        if (bonusnumber == a[i])
        {
            throw IllegalArgumentException("[ERROR] 기존 번호와 보너스 번호가 같습니다.")
        }
    }
    if (bonusnumber > 45 || bonusnumber < 1)
    {
        throw IllegalArgumentException("[ERROR] 값은 1부터 45까지 입니다.")
    }
    return bonusnumber
}



fun comparenumber(a:MutableList<MutableList<Int>> , b:IntArray , c:Int) : IntArray {
    var countunion = IntArray(a.size)
    for (i in 0..a.size-1)
    {
        var count = 0
        var bonuscount = 0

        for (j in 0..5)
        {
            if (b[0] == a[i][j])
            {
                count+=1
            }
            if (b[1] == a[i][j])
            {
                count+=1
            }
            if (b[2] == a[i][j])
            {
                count+=1
            }
            if (b[3] == a[i][j])
            {
                count+=1
            }
            if (b[4] == a[i][j])
            {
                count+=1
            }
            if( b[5] == a[i][j])
            {
                count+=1
            }
            if( c==a[i][j])
            {
                bonuscount +=1
            }
        }
        countunion[i]=count
        if (bonuscount > 0 && countunion[i] == 5)
        {
            countunion[i]+=10
        }
    }
    return countunion
}

fun calculater (a:IntArray) : Int
{
    var money = 0
    var rank = IntArray(5,)
    for(item in a){ when(item){
            3 -> { rank[0] += 1
                money+=5000 }
            4 -> { rank[1] += 1
                money+=5000 }
            5 -> { rank[2] += 1
                money+=5000 }
            6 -> { rank[3] += 1
                money+=5000 }
            15 -> { rank[4] += 1
                money+=5000 } }
    }
    printwin(rank)
    return money
}
fun printwin (a:IntArray)
{
    println("3개 일치 (5,000원) - ${a[0]}개")
    println("4개 일치 (50,000원) - ${a[1]}개")
    println("5개 일치 (1,500,000원) - ${a[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${a[3]}개")
    println("6개 일치 (2,000,000,000원) - ${a[4]}개")
}

fun profit (a: Int , b: Int) : Double
{
    var aa = a.toDouble()
    var bb = b.toDouble()
    var result = (bb/aa)*100

    return result
}






