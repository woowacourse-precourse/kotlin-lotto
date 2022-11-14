package lotto.view

import lotto.domain.model.Lotto
import lotto.domain.model.Rank

object OutputView {
    // TODO 출력을 담당하는 뷰

    fun purchasingLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.toString())
        }
        println()
    }

    fun printSummary(statistics: List<Rank>) {
        println("당첨 통계\n---")
        for (rank in Rank.values()) {
            if (rank == Rank.CORRECT_ZERO) continue
            val rankCnt = statistics.count { it == rank }
            println("${rank.getCount()}개 일치 (5,000원) - ${rankCnt}개")
        }
    }

    fun earningRate(earningRate: String) {
        println("총 수익률은 ${earningRate}입니다.")
    }

}