package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}