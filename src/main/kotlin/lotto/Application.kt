package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("구입금액을 입력해 주세요.")
    var moneyInput = Console.readLine()
    if(stringCheck(moneyInput)) {
        print("[ERROR]")
        throw NoSuchElementException()
    }

    var lottoCount = moneyInput!!.toInt()/1000
    println("${lottoCount}개를 구매했습니다.")

    var randomlotto = makeRandomLotto(lottoCount)

    println("당첨 번호를 입력해 주세요.")
    var myNumber = Console.readLine()
    var myList = myNumber!!.split(',').map { it.toInt() }.toList()

    println("보너스 번호를 입력해 주세요.")
    var bonusNumber = Console.readLine()
}

fun makeRandomLotto(count:Int): MutableList<List<Int>> {
    var lottolist = mutableListOf<List<Int>>()
    for (i in 1..count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        lottolist.add(numbers)
        println(numbers)
    }
    return lottolist
}

fun stringCheck(str: String):Boolean{
    var element:Char
    var flag = false

    for(i in str.indices){
        element = str.elementAt(i)
        if (element.toInt()<48||element.toInt()>57){
            flag = true
        }
    }
    return flag
}
