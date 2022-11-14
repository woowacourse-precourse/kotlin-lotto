package lotto.domain.repository

import lotto.domain.model.Lotto
import lotto.domain.model.Rank
import lotto.domain.model.WinningLottery

class LottoRepository {

    fun generateLottos(money: Int): List<Lotto> {
        val purchaseLottos = mutableListOf<Lotto>()
        repeat(money / Lotto.LOTTO_PRIZE) {
            purchaseLottos.add(Lotto.newInstance())
        }
        return purchaseLottos.toList()
    }

    fun calEarningRate(purchasePrize: Int, totalPrice: Long): Double {
        return (totalPrice / purchasePrize.toDouble() * 100)
    }

    fun calStatistics(winningLottery: WinningLottery, purchaseLottos: List<Lotto>): List<Rank> {
        return purchaseLottos.map { lotto ->
            winningLottery.compareLotto(lotto)
        }
    }
}