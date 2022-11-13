package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

object LottoFactory {

    fun createRandomLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }
}