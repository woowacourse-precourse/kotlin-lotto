package lotto.domain.model

import lotto.utils.Constants
import lotto.utils.Constants.BONUS_NOT_DUPLICATE_TEXT
import lotto.utils.Constants.ZERO

class WinningLottery(private val winningNum: List<Int>, private val bonus: Int) {

    init {
        require(!winningNum.contains(bonus)) {
            BONUS_NOT_DUPLICATE_TEXT
        }
    }

    fun compareLotto(lotto: Lotto): Rank {
        var count = ZERO
        winningNum.forEach {
            if (lotto.contains(it)) count++
        }
        return Rank.valueOf(count, lotto.contains(bonus))
    }


}
