package lotto.domain.repository

import lotto.domain.model.Lotto

class LottoRepository {

    fun generateLottos(money: Int): List<Lotto> {
        val purchaseLottos = mutableListOf<Lotto>()
        repeat(money / Lotto.LOTTO_PRIZE) {
            purchaseLottos.add(Lotto.newInstance())
        }
        return purchaseLottos.toList()
    }

}