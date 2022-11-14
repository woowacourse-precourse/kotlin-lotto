package lotto.lottoshop.lottomachine

import camp.nextstep.edu.missionutils.Randoms.*
import lotto.Lotto
import lotto.LottoRule.LOTTO_NUMBER_RANGE_END
import lotto.LottoRule.LOTTO_NUMBER_RANGE_START
import lotto.LottoRule.LOTTO_SIZE

class LottoMachineImpl : LottoMachine {
    override fun drawLotto(): Lotto {
        return Lotto(
            pickUniqueNumbersInRange(
                LOTTO_NUMBER_RANGE_START,
                LOTTO_NUMBER_RANGE_END,
                LOTTO_SIZE
            ).sorted()
        )
    }
}
