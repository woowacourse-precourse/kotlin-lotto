package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.Lotto

object LottoGenerator {

    fun generate(size: Int): List<Lotto> {
        return List(size) { Lotto(
            Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LENGTH)
        ) }
    }
}
