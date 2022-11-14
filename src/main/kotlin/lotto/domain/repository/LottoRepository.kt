package lotto.domain.repository

import lotto.domain.model.Lotto
import lotto.domain.model.Rank
import lotto.domain.model.WinningLottery
import java.math.RoundingMode
import java.text.DecimalFormat

class LottoRepository {

    fun generateLottos(money: Int): List<Lotto> {
        val purchaseLottos = mutableListOf<Lotto>()
        repeat(money / Lotto.LOTTO_PRIZE) {
            purchaseLottos.add(Lotto.newInstance())
        }
        return purchaseLottos.toList()
    }

    fun calEarningRate(purchasePrize: Int, winningPrize: Int): String {
        val dec = DecimalFormat("#,###.0")
        return dec.format(
            (winningPrize * 100.0).toBigDecimal().divide(purchasePrize.toBigDecimal(), 1, RoundingMode.FLOOR)
        )
    }

    fun calStatistics(winningLottery: WinningLottery, purchaseLottos: List<Lotto>): List<Rank> {
        return purchaseLottos.map { lotto ->
            winningLottery.compareLotto(lotto)
        }
    }
}