package lotto.presentation

import lotto.domain.LottoReward
import lotto.presentation.util.Constant.fifthReward
import lotto.presentation.util.Constant.firstReward
import lotto.presentation.util.Constant.fourthReward
import lotto.presentation.util.Constant.percent
import lotto.presentation.util.Constant.printRankMessage
import lotto.presentation.util.Constant.secondReward
import lotto.presentation.util.Constant.thirdReward
import lotto.presentation.util.Constant.yieldEndMessage
import lotto.presentation.util.Constant.yieldMessage
import kotlin.math.roundToInt

class LottoBank {

    fun yieldLotto(rank: List<Int>, charger: Int) {
        val rate =
            ((rank[0] * fifthReward) + (rank[1] * fourthReward) + (rank[2] * thirdReward) + (rank[3] * secondReward) + (rank[4] * firstReward)).toDouble()

        println(printRankMessage)
        println("${LottoReward.FIFTH.cnt}개 일치 (${LottoReward.FIFTH.prize}원) - ${rank[0]}개")
        println("${LottoReward.FOURTH.cnt}개 일치 (${LottoReward.FOURTH.prize}원) - ${rank[1]}개")
        println("${LottoReward.THIRD.cnt}개 일치 (${LottoReward.THIRD.prize}원) - ${rank[2]}개")
        println("${LottoReward.SECOND.cnt}개 일치, 보너스 볼 일치 (${LottoReward.SECOND.prize}원) - ${rank[3]}개")
        println("${LottoReward.FIRST.cnt}개 일치 (${LottoReward.FIRST.prize}원) - ${rank[4]}개")
        println(yieldMessage + "%.1f".format(rate.toFloat() / charger * percent) + yieldEndMessage)

    }
}