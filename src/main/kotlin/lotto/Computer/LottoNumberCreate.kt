package lotto.Computer

import camp.nextstep.edu.missionutils.Randoms

fun NumberCreate () : List<Int>{
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return numbers
}



