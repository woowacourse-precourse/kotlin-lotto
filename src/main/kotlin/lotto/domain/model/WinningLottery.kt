package lotto.domain.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.controller.LottoController.Companion.ERROR_MESSAGE
import lotto.domain.model.Prize.*

class WinningLottery(private val winningNum: List<Int>, private val bonus: Int) {

    fun compareLotto(lotto: Lotto): Rank {
        var count = 0
        winningNum.forEach {
            if (lotto.contains(it)) count += 1
        }
        return Rank.valueOf(count, lotto.contains(bonus))
    }

}
