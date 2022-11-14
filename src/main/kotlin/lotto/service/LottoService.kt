package lotto.service

import lotto.domain.LottoShop
import lotto.domain.WinningNumber
import lotto.domain.WinningStatistics
import lotto.repository.LottoRepository
import lotto.service.dto.LottoDto
import lotto.service.dto.WinningStatisticsDto

object LottoService {

    fun purchaseLotteries(purchaseAmount: Int): List<LottoDto> {
        val lotteries = LottoShop.purchaseLotteries(purchaseAmount)
        LottoRepository.saveAll(lotteries)
        return lotteries.map { LottoDto(it) }
    }

    fun getWinningStatistics(winningNumbers: List<Int>, bonusNumber: Int): WinningStatisticsDto {
        val lotteries = LottoRepository.findAll()
        val winningNumber = WinningNumber(winningNumbers, bonusNumber)
        val winningStatistics = WinningStatistics(lotteries, winningNumber)
        return WinningStatisticsDto(winningStatistics)
    }
}