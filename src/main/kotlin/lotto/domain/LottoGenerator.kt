package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoGenerator {
    fun generateLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }
}