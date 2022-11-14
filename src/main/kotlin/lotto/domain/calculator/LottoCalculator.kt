package lotto.domain.calculator

import lotto.domain.model.statistics.enums.LottoWinningResult
import lotto.domain.model.ticket.LottoTicket
import lotto.domain.model.winning.WinningLotto

object LottoCalculator {
    val winningTicketCount = mutableMapOf(
        LottoWinningResult.FIFTH to 0,
        LottoWinningResult.FOURTH to 0,
        LottoWinningResult.THIRD to 0,
        LottoWinningResult.SECOND to 0,
        LottoWinningResult.FIRST to  0,
    )

    fun calculateTotalProfitRate() {
        var totalRate = 0.0

    }

    fun calculateWinningTicketCount(
        lottoTicket: LottoTicket,
        winningLotto: WinningLotto
    ) {
        lottoTicket.lottos.forEach { lotto ->
            val lottoResult = checkLottoResult(lottoNumbers = lotto.getLottoNumbers(), winningLotto = winningLotto)

            if (winningTicketCount.containsKey(lottoResult))
                winningTicketCount[lottoResult] = winningTicketCount[lottoResult]!! + 1
        }
    }

    private fun checkLottoResult(lottoNumbers: List<Int>, winningLotto: WinningLotto): LottoWinningResult {
            val (winningNumbers, bonusNumber) = winningLotto
            val isBonusMatch = lottoNumbers.contains(bonusNumber)
            var matchNumberCount = lottoNumbers.count{ number -> winningNumbers.contains(number) }

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