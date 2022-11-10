package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.LOTTO_LENGTH
import lotto.LOTTO_MAX_NUM
import lotto.LOTTO_MIN_NUM

object LottoFactory {
    fun generate() = Lotto(
        Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LENGTH)
    )
}
