package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")
    val moneyInput = Console.readLine()
    val moneyCount = Money(moneyInput)
    println("${moneyCount.run()}개를 구매했습니다.")
    val randomlotto = makeRandomLotto(moneyCount.run())

    println("당첨 번호를 입력해 주세요.")
    val myNumber = Console.readLine()
    val myList = myNumber!!.split(',').map { it.toInt() }.toList()
    Lotto(myList)

    println("보너스 번호를 입력해 주세요.")
    val myBonus = Console.readLine()
    val bonusNumber = myBonus.toInt()
    if (bonusNumber !in (1..45) )
        throw IllegalArgumentException("[ERROR] : 올바른 범위의 숫자를 입력해 주세요.(1~45)")
    if (myList.contains(bonusNumber))
        throw IllegalArgumentException("[ERROR] : 입력한 당첨 번호와 중복됩니다.")

    val lottoStatistic = Calculate(randomlotto, myList, bonusNumber, moneyInput.toInt())
    lottoStatistic.run()
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