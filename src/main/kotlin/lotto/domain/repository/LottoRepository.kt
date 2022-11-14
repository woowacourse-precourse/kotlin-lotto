package lotto.domain.repository

import lotto.domain.model.Lotto
import lotto.domain.model.Money
import lotto.domain.model.Rank
import lotto.domain.model.WinningLottery

class LottoRepository {
    fun generateLottos(money: Long): List<Lotto> {
        val purchaseLottos = mutableListOf<Lotto>()
        repeat((money / Lotto.LOTTO_PRIZE).toInt()) {
            purchaseLottos.add(Lotto.newInstance())
        }
        return purchaseLottos.toList()
    }

    fun calEarningRate(purchasePrize: Money, totalPrice: Long): Double {
        return (totalPrice / purchasePrize.getMoney() * 100.0)
    }

    fun calStatistics(winningLottery: WinningLottery, purchaseLottos: List<Lotto>): List<Rank> {
        return purchaseLottos.map { lotto ->
            winningLottery.compareLotto(lotto)
        }
    }
}