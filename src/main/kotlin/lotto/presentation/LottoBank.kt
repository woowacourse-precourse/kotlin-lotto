package lotto.presentation

import lotto.domain.LottoReward
import kotlin.math.roundToInt

class LottoBank {

    fun yieldLotto(rank : List<Int>, charger: Int) {
        val rate= ((rank[0] * 5000) + (rank[1] * 50000) + (rank[2] * 1500000) + (rank[3] * 30000000) + (rank[4] * 2000000000)).toDouble() / charger

        println("\n당첨 통계")
        println("---")
        println("${LottoReward.FIFTH.cnt}개 일치 (${LottoReward.FIFTH.prize}원) - ${rank[0]}개")
        println("${LottoReward.FOURTH.cnt}개 일치 (${LottoReward.FOURTH.prize}원) - ${rank[1]}개")
        println("${LottoReward.THIRD.cnt}개 일치 (${LottoReward.THIRD.prize}원) - ${rank[2]}개")
        println("${LottoReward.SECOND.cnt}개 일치, 보너스 볼 일치 (${LottoReward.SECOND.prize}원) - ${rank[3]}개")
        println("${LottoReward.FIRST.cnt}개 일치 (${LottoReward.FIRST.prize}원) - ${rank[4]}개")
        println("총 수익률은 ${(rate * 1000).roundToInt().toDouble() / 10}%입니다.")
    }
}