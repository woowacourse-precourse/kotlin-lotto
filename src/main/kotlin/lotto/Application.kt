package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun createLottoNum(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}
fun createBonusNum(lottoNum:List<Int>):Int
{
    var remainder = (1..45).toMutableList()
    var ret :Int
    for(i in lottoNum) {
        if (remainder.contains(i))
            remainder.remove(i)
    }
    ret = Randoms.pickNumberInList(remainder)
    return ret
}

fun publishLotto(money : Int):List<List<Int>>
{
    var table = mutableListOf<List<Int>>()
    var i :Int = 0
    while (i < (money / 1000)){
        table.add(createLottoNum())
        i++;
    }
    return table
}
fun printLottos(table : List<List<Int>>){
    for (i in table)
        println(i)
}
fun inputMoney() : Int{
    var money = Console.readLine()
    require(money.all{it.isDigit()}){"[ERROR] 숫자만 입력해야 합니다."}
    require(money.toInt()%1000 == 0){"[ERROR] 금액은 1000으로 나누어 떨어져야 합니다."}

    return money.toInt()
}

fun main() {
    val numbers = createLottoNum()
    val numbers2 = listOf<Int>(1,2,3,4,5,5)
    val bonus = createBonusNum(numbers)
    var table = mutableListOf<List<Int>>()
    println(numbers)
    println(bonus)
    //Lotto(numbers)
    //Lotto(numbers2)
    table = publishLotto(8000) as MutableList<List<Int>>
    printLottos(table)
    inputMoney()
}
