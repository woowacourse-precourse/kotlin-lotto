package view

import domain.Lotto
import domain.Rank
import lotto.LottoMessage
import java.text.DecimalFormat
import java.util.stream.Collectors
import kotlin.math.pow
import kotlin.math.roundToInt

object OutputView {
    fun printStat(ranking: Map<Rank, Int>, incomePercent: Double) {
        println(LottoMessage.WINNING_STATS)
        printRanking(ranking)
        printIncomePercent(incomePercent)
    }

    private fun printRanking(ranking: Map<Rank, Int>) {
        val sortedRank: List<Rank> = ranking.keys
            .stream()
            .sorted(Comparator.comparing(Rank::reward))
            .collect(Collectors.toList())
        sortedRank.forEach {
            if (it != Rank.NOTHING) {
                println(makeRakingMessage(it, ranking[it]!!))
            }
        }
    }

    private fun makeRakingMessage(rank: Rank, winningCount: Int): String {
        val decFormat = DecimalFormat(LottoMessage.DECIMAL_FORMAT)

        if (rank === Rank.SECOND_PLACE) {
            return (
                "${rank.rank}${LottoMessage.NUMBER_MATCH}, ${LottoMessage.BONUS_NUMBER_MATCH} (${
                decFormat.format(rank.reward)
                }${LottoMessage.WON}) - ${winningCount}${LottoMessage.EA}"
                )
        }
        return ("${rank.rank}${LottoMessage.NUMBER_MATCH} (${decFormat.format(rank.reward)}${LottoMessage.WON}) - ${winningCount}${LottoMessage.EA}")
    }

    private fun printIncomePercent(incomePercent: Double) {
        print(
            "${LottoMessage.TOTAL_RETURN_FRONT} " +
                String.format("%.1f", roundFromSecondDigit(incomePercent * 100)) +
                LottoMessage.TOTAL_RETURN_END
        )
    }

    fun printLotteries(lotteries: List<Lotto>) {
        println("${lotteries.size}개를 구매했습니다.")
        lotteries.forEach { println(it.numbers.toString()) }
        println()
    }

    private fun roundFromSecondDigit(number: Double): Double {
        return (number * 10.0.pow(2.toDouble())).roundToInt() / 10.0.pow(2.toDouble())
    }
}
