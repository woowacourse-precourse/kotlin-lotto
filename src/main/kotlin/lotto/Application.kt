package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    //TODO("프로그램 구현")
//    var winningnum = winningnumselect()
//
//    var usermoney = moneyinput()
//    moneycheck(usermoney)
//    var ticket = usermoney/1000
//    println("${ticket}개를 구매했습니다.")
//    var userlottolist = userselectnum(ticket)
//    println("")
//    var wincountlist = comparenumber(winningnum,userlottolist,bonusnumber)
//    var a = calculater(wincountlist)
//    println(a)

    println("구입금액을 입력해 주세요.")
    var usermoney = moneyinput()
    moneycheck(usermoney)
    var ticket = usermoney/1000
    println("${ticket}개를 구매했습니다.")
    var usernumber = userpicknumber(ticket)
    printusernumber(usernumber)
    println("당첨 번호를 입력해 주세요.")
    var winningnumber = winningselectnum()
    println("보너스 번호를 입력해 주세요.")
    var bonusnumber = bonusnumber(winningnumber)
    var pointnumber = comparenumber(usernumber,winningnumber,bonusnumber)
    println(pointnumber)






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
    }
    return numbers
}

fun moneyinput () : Int {
    var money = readLine()!!.toInt()
    return money
}
fun moneycheck (a : Int){
    if (a%1000 != 0)
    {
        throw IllegalArgumentException("1000원 단위로 입력해주세요.")
    }
}

fun winningselectnum () : IntArray
{
    var usernumber = IntArray(6)
    var strinput = readLine()!!.toString()
    var inputslit =strinput.split(",")

    for (i in 0..5)
    {
        var inputvalue = inputslit[i].toInt()
        usernumber[i]=inputvalue
    }
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
        println("")
    }
    return countunion
}

fun calculater (a:IntArray) : Int
{
    var money = 0
    var rank5 = 0
    var rank4 = 0
    var rank3 = 0
    var rank2 = 0
    var rank1 = 0
    for (i in 0..a.size-1)
    {


        if (a[i] == 3)
        {
            rank5+=1
            money+=5000
        }
        if (a[i] == 4)
        {
            rank4+=1
            money+=50000
        }
        if (a[i]==5)
        {
            rank3+=1
            money+=150000
        }
        if (a[i]== 6 )
        {
            rank1+=1
            money+=2000000000
        }
        if (a[i] == 5)
        {
            rank2+=1
            money+=30000000
        }
    }
    println("3개 일치 (5,000원) - ${rank5}개")
    println("4개 일치 (50,000원) - ${rank4}개")
    println("5개 일치 (1,500,000원) - ${rank3}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rank2}개")
    println("6개 일치 (2,000,000,000원) - ${rank1}개")
    return money
}





