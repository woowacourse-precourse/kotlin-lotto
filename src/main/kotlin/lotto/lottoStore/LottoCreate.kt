package lotto.lottoStore

import camp.nextstep.edu.missionutils.Randoms


class LottoCreate(){
fun createLotto(inputUserNumber: String): MutableList<List<Int>> {
    val lotto = mutableListOf<List<Int>>()
    for (i in 1..inputUserNumber.toInt()) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(numbers.sorted())
        lotto.add(Lotto.Lotto(numbers.sorted()).getNumbers())
    }
    return lotto
}
}