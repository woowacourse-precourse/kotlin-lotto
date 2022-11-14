package lotto.domain.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.controller.LottoController.Companion.ERROR_MESSAGE
import lotto.domain.model.Prize.*

class WinningLottery(private val winningNum: List<Int>, private val bonus: Int) {

    fun compareLotto(lotto: Lotto): Rank {
        val count = winningNum.count { lotto.contains(it) }
        return Rank.valueOf(count, lotto.contains(bonus))
    }

}
