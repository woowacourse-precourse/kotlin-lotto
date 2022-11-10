package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    //TODO("프로그램 구현")
    var winningnum = winningnumselect()
    var usermoney = moneyinput()
    moneycheck(usermoney)
    var ticket = usermoney/1000


}


fun winningnumselect () : MutableList<Int> {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45 ,6)
    return numbers
}

fun moneyinput () : Int {
    var money = readLine()!!.toInt()
    return money
}
fun moneycheck (a : Int){
    if (a%1000 != 0)
    {
        throw new IllegalArgumentException("1000원 단위로 입력해주세요.")
    }
}

fun userselectnum (a: Int) : MutableList<Int>
{
    for ()

}
