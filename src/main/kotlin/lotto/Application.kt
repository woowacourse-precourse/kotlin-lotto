package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("구입금액을 입력해 주세요.")
    var moneyInput = Console.readLine()

    var lottoCount = moneyInput!!.toInt()/1000
    println("${lottoCount}개를 구매했습니다.")

    var randomlotto = MakeRandomLotto(lottoCount)
    println(randomlotto)
}

fun MakeRandomLotto(count:Int): MutableList<List<Int>> {
    var lottolist = mutableListOf<List<Int>>()
    for (i in 1..count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        lottolist.add(numbers)
        println(numbers)
    }
    return lottolist
}
