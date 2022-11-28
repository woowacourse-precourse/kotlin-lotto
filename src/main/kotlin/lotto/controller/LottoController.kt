package lotto.controller

import lotto.domain.model.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoStore = LottoStore()

    fun play() {
        val inputMoney = Money(inputView.inputMoney())
        val purchaseLottos = purchaceLotto(inputMoney)

        val winningLottery = WinningLottery(inputView.inputWinningNum(), inputView.inputBonusNum())
        val statistics = calStatistics(winningLottery, purchaseLottos)
        val earningRate = calEarningRate(inputMoney, getTotalPrice(statistics))
        printResult(statistics, earningRate)
    }

    private fun purchaceLotto(inputMoney: Money): List<Lotto> {
        val purchaseLottos = lottoStore.purchaseLotto(inputMoney.getMoney())
        outputView.purchasingLottos(purchaseLottos)
        return purchaseLottos
    }

    private fun getTotalPrice(statistics: List<Rank>) = statistics.sumOf { it.prize.toLong() }

    private fun printResult(statistics: List<Rank>, earningRate: Double) {
        outputView.run {
            printSummary(statistics)
            earningRate(earningRate)
        }
    }

    private fun calEarningRate(purchasePrize: Money, totalPrice: Long): Double {
        return (totalPrice / purchasePrize.getMoney().toDouble() * 100.0)
    }

    private fun calStatistics(winningLottery: WinningLottery, purchaseLottos: List<Lotto>): List<Rank> {
        return purchaseLottos.map { lotto ->
            winningLottery.compareLotto(lotto)
        }
    }

}