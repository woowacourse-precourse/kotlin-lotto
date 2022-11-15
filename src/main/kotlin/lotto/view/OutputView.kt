package lotto.view

import lotto.domain.Lotto
import lotto.domain.LotteryChecker
import lotto.domain.Money
import lotto.domain.Rank

object OutputView {

    private val builder = StringBuilder()

    fun printLottoCount(lottoCount: Long) {
        println("\n${lottoCount}개를 구매했습니다.")
    }

    fun printLottoNumber(lottoTicket: List<Lotto>) {
        lottoTicket.forEach { lotto: Lotto ->
            builder.append(lotto.value()).append('\n')
        }

        println(builder)
        builder.setLength(0)
    }

    fun printResult(lotteryChecker: LotteryChecker) {
        builder.append("\n당첨 통계\n")
            .append("---")

        for (rank in Rank.values()) {
            if (rank == Rank.FAIL) continue
            builder.append('\n').append(printWinningRecord(rank, lotteryChecker))
        }
        println(builder)
        builder.setLength(0)
    }

    private fun printWinningRecord(rank: Rank, lotteryChecker: LotteryChecker): String {
        return String.format(
            "%d개 일치%s (%,d원) - %d개",
            rank.getCount(),
            hasBonusNumber(rank),
            rank.getPrice(),
            lotteryChecker.score(rank)
        )
    }

    private fun hasBonusNumber(rank: Rank): String {
        if (rank == Rank.SECOND) return ", 보너스 볼 일치"
        return ""
    }

    fun printRateOfProfit(money: Money, totalPrice: Long) {
        println(String.format("총 수익률은 %.1f", calculateRatingOfProfit(money, totalPrice)) + "%입니다.")
    }

    private fun calculateRatingOfProfit(money: Money, totalPrice: Long): Double {
        return (totalPrice / money.value().toDouble() * 100)
    }
}
