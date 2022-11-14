package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.Lotto
import lotto.data.WinningLotto

object LottoGenerator {

    fun generate(size: Int): List<Lotto> {
        return List(size) { Lotto(
            Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LENGTH)
        ) }
    }

    fun generateWinningNumbers(): WinningLotto {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LENGTH + 1).let {
            WinningLotto(it.take(Lotto.LENGTH), it.last())
        }
    }
}
