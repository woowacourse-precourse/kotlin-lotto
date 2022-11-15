package lotto.domain.calculator

import lotto.domain.model.statistics.WinningTotalStatistics
import lotto.domain.model.statistics.enums.LottoWinningResult
import lotto.domain.model.ticket.LottoTicket
import lotto.domain.model.winning.WinningLotto
import kotlin.math.roundToInt

object LottoCalculator {
    fun getWinningTotalStatistics(lottoTicket: LottoTicket, winningLotto: WinningLotto): WinningTotalStatistics {
        val winningHistories = calculateWinningHistories(lottoTicket, winningLotto)
        val totalProfitRate = calculateTotalProfitRate(lottoTicket, winningHistories)

        return WinningTotalStatistics(winningHistories = winningHistories, totalProfitRate = totalProfitRate)
    }

    private fun calculateTotalProfitRate(
        lottoTicket: LottoTicket,
        winningHistories: MutableMap<LottoWinningResult, Int>
    ): Double {
        var totalProfit = 0.00

        winningHistories.forEach { (lottoWinningResult, ticketCount) ->
            totalProfit += lottoWinningResult.profit * ticketCount
        }

        return roundProfitRate(((totalProfit / lottoTicket.ticketMoney) * 100))
    }

    private fun roundProfitRate(profitRate: Double): Double =
        ((profitRate * 100).roundToInt() / 100f).toDouble()

    private fun calculateWinningHistories(
        lottoTicket: LottoTicket,
        winningLotto: WinningLotto
    ): MutableMap<LottoWinningResult, Int> {

        /** 당첨내역 : 당첨결과 to 당첨 티켓 개수 **/
        val winningHistories = WinningTotalStatistics.emptyWinningHistories

        lottoTicket.lottos.forEach { lotto ->
            val lottoResult = checkLottoResult(lottoNumbers = lotto.getLottoNumbers(), winningLotto = winningLotto)

            if (winningHistories.containsKey(lottoResult))
                winningHistories[lottoResult] = winningHistories[lottoResult]!! + 1
        }

        return winningHistories
    }

    private fun checkLottoResult(lottoNumbers: List<Int>, winningLotto: WinningLotto): LottoWinningResult {
        val (winningNumbers, bonusNumber) = winningLotto
        val isBonusMatch = lottoNumbers.contains(bonusNumber)
        var matchNumberCount = lottoNumbers.count { number -> winningNumbers.contains(number) }

        if (isBonusMatch) matchNumberCount += 1

        val lottoResult = when (matchNumberCount) {
            6 -> LottoWinningResult.FIRST
            5 -> if (isBonusMatch) LottoWinningResult.SECOND else LottoWinningResult.THIRD
            4 -> LottoWinningResult.FOURTH
            3 -> LottoWinningResult.FIFTH
            else -> LottoWinningResult.LOSE
        }
        return lottoResult
    }
}