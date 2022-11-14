package lotto.controller

import lotto.domain.model.Money
import lotto.domain.model.Rank
import lotto.domain.model.WinningLottery
import lotto.domain.repository.LottoRepository
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    private val lottoRepository = LottoRepository()

    fun play() {
        val purchaseMoney = Money(InputView.inputMoney())
        val purchaseLottos = lottoRepository.generateLottos(purchaseMoney.getMoney())
        OutputView.purchasingLottos(purchaseLottos)

        val winningLottery = WinningLottery(InputView.inputWinningNum(), InputView.inputBonusNum())
        val statistics = lottoRepository.calStatistics(winningLottery, purchaseLottos)
        val earningRate = lottoRepository.calEarningRate(purchaseMoney, statistics.sumOf { it.prize.toLong() })
        printResult(statistics, earningRate)
    }

    private fun printResult(statistics: List<Rank>, earningRate: Double) {
        OutputView.run {
            printSummary(statistics)
            earningRate(earningRate)
        }
    }


}