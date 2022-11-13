package lotto.lottoStore

import camp.nextstep.edu.missionutils.Randoms

fun createLotto(inputUserNumber: String): MutableList<List<Int>> {
    val a = mutableListOf<List<Int>>()
    for (i in 1..inputUserNumber.toInt()) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(numbers.sorted())
        a.add(numbers.sorted())
    }
    return a
}
