package lotto.domain.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_LENGTH
import lotto.utils.Constants.MAX_LOTTO_NUM
import lotto.utils.Constants.MIN_LOTTO_NUM

class LottoNumberGenerator : GenerateLottoNumber {

    override fun generate(): List<Int> =
        Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_LENGTH)
            .sorted()
}