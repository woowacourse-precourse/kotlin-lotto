package lotto.domain

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.Lotto

object GenerateLotto {

    fun generate(): Lotto {
        return Lotto(pickUniqueNumbersInRange(1, 45, 6))
    }


}