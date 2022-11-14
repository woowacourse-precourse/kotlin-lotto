package lotto.view

import lotto.domain.model.Lotto
import lotto.domain.model.Rank
import java.text.DecimalFormat

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
        val dec = DecimalFormat("#,###")
        println("당첨 통계\n---")
        for (rank in Rank.values()) {
            if (rank == Rank.CORRECT_ZERO) continue
            val rankCnt = statistics.count { it == rank }
            if (rank == Rank.CORRECT_FIVE_BONUS) {
                println("${rank.getCount()}개 일치, 보너스 볼 일치 (${dec.format(rank.prize)}원) - ${rankCnt}개")
                continue
            }
            println("${rank.getCount()}개 일치 (${dec.format(rank.prize)}원) - ${rankCnt}개")
        }
    }

    fun earningRate(earningRate: Double) {
        println(String.format("총 수익률은 %.1f", earningRate) + "%입니다.")
    }

}