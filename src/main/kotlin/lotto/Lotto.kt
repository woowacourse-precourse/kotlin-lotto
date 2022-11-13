package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    val pickLottoNums = pickUniqueNumbersInRange(1, 45, 6)
}