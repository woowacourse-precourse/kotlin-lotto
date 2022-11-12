package lotto.lottoStore

import camp.nextstep.edu.missionutils.Randoms

fun lottoCreate(){
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    println(numbers.sorted())
}
