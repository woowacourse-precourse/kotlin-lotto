package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    //TODO("프로그램 구현")
    var winningnum = winningnumselect()
    var bonusnumber = bonusball()
    var usermoney = moneyinput()
    moneycheck(usermoney)
    var ticket = usermoney/1000
    println("${ticket}개를 구매했습니다.")
    var userlottolist = userselectnum(ticket)
    println("")
    var wincountlist = comparenumber(winningnum,userlottolist,bonusnumber)
    var a = calculater(wincountlist)
    println(a)

}


fun winningnumselect () : MutableList<Int> {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45 ,6)
    println(numbers)
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

fun userselectnum (a: Int) : Array<IntArray>
{
    var usernumber = Array(a){IntArray(6)}
    for (j in 0..a-1)
    {

        var strinput = readLine()!!.toString()
        var inputslit =strinput.split(",")

        for (i in 0..5)
        {
            var inputvalue = inputslit[i].toInt()
            usernumber[j][i]=inputvalue
        }
    }
    return usernumber
}

fun comparenumber(a:MutableList<Int> , b:Array<IntArray> , c:MutableList<Int>) : IntArray {
    var countunion = IntArray(b.size)
    for (i in 0..b.size-1)
    {
        var count = 0

        for (j in 0..5)
        {
            if (a[0] == b[i][j])
            {
                count+=1
            }
            if (a[1] == b[i][j])
            {
                count+=1
            }
            if (a[2] == b[i][j])
            {
                count+=1
            }
            if (a[3] == b[i][j])
            {
                count+=1
            }
            if (a[4] == b[i][j])
            {
                count+=1
            }
            if(a[5] == b[i][j])
            {
                count+=1
            }

        }
        countunion[i]=count
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





