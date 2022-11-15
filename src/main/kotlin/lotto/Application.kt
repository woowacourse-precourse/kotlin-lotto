package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")
    val moneyInput = Console.readLine()
    val moneCheck = Money(moneyInput)
    val moneyCount = moneCheck.run()
    println("${moneyCount}개를 구매했습니다.")

    val randomlotto = makeRandomLotto(moneyCount)

    println("당첨 번호를 입력해 주세요.")
    val myNumber = Console.readLine()
    val myList = myNumber!!.split(',').map { it.toInt() }.toList()
    Lotto(myList)

    println("보너스 번호를 입력해 주세요.")
    val myBonus = Console.readLine()
    val bonusCheck = Bonus(myBonus, myList)
    val bonusNumber = bonusCheck.run()

    val lottotStatistic = Lotto(myList)
    lottotStatistic.run(randomlotto, myList, bonusNumber, moneyInput.toInt())
}

fun makeRandomLotto(count: Int): MutableList<List<Int>> {
    var lottolist = mutableListOf<List<Int>>()
    for (i in 1..count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        lottolist.add(numbers)
        println(numbers)
    }
    return lottolist
}