package lotto.Computer

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.ErrorCheck

public val lottoList: MutableList<List<Int>> = ArrayList()

fun NumberCreate(ticket : Int) : MutableList<List<Int>> {
    for (i in 1..ticket) {
        val numbers = RandomCreate().sorted()
        lottoList.add((numbers))
    }
    return lottoList
}

fun RandomCreate(): List<Int> {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return numbers
}



