package lotto.domain.calculator

import lotto.domain.model.statistics.enums.LottoWinningResult
import lotto.domain.model.ticket.LottoTicket
import lotto.domain.model.winning.WinningLotto

object LottoCalculator {
    val winningResult = hashMapOf(
        LottoWinningResult.FIFTH to 0,
        LottoWinningResult.FOURTH to 0,
        LottoWinningResult.THIRD to 0,
        LottoWinningResult.SECOND to 0,
        LottoWinningResult.FIRST to  0,
    )

    fun calculateWinningTicketCount(
        lottoTicket: LottoTicket,
        winningLotto: WinningLotto
    ) {
        lottoTicket.lottos.forEach {
            val lottoResult = checkLottoResult(lottoNumbers = it.getLottoNumbers(), winningLotto = winningLotto)
            winningResult[lottoResult]?.plus(1)
        }
    }

    private fun checkLottoResult(lottoNumbers: List<Int>, winningLotto: WinningLotto): LottoWinningResult {
            val (winningNumbers, bonusNumber) = winningLotto
            val isBonusMatch = lottoNumbers.contains(bonusNumber)
            val matchNumberCount = lottoNumbers.count{ number -> winningNumbers.contains(number) }

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