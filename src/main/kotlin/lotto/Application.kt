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
fun inputWinNum() : List<String> {
    var nums = (Console.readLine().split(","))
    require(nums.size == 6){"[ERROR] : 숫자가 6개가 아닙니다."}
    require(nums.distinct().size==6){"[ERROR] : 중복된 숫자가 있습니다"}
    require(nums.all{it.all{it.isDigit()}}){"[ERROR] 숫자만 입력해야 합니다."}
    require(nums.all{it.toInt() in 1..45}){"[ERROR] 1부터 45까지의 숫자를 입력해야 합니다."}

    return nums
}
fun inputBonusNum(winNum:List<String>):Int{
    var remainder = (1..45).toMutableList()
    for(i in winNum) {
        if (remainder.contains(i.toInt()))
            remainder.remove(i.toInt())
    }
    var ret :String = Console.readLine()
    require(ret.isNotEmpty()){"[ERROR] 값을 입력해야 합니다."}
    require(ret.all{it.isDigit()}){"[ERROR] 숫자만 입력해야 합니다."}
    require(remainder.contains(ret.toInt())){"[ERROR] : 올바른 숫자가 아닙니다."}
    return ret.toInt()
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
    //inputMoney()
    //inputWinNum()
    inputBonusNum(inputWinNum())
}
